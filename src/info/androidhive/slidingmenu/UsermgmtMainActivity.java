/**
 * Copyright 2014 Daum Kakao Corp.
 *
 * Redistribution and modification in source or binary forms are not permitted without specific prior written permission.혻
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package info.androidhive.slidingmenu;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.capstone.CapstoneApplication;
import com.example.capstone.activities.Game;
import com.example.capstone.adapter.NavDrawerListAdapter;
import com.example.capstone.fragment.FragmentBoard;
import com.example.capstone.fragment.FragmentCommunity;
import com.example.capstone.fragment.FragmentEmergencyCall;
import com.example.capstone.fragment.FragmentFakecall;
import com.example.capstone.fragment.FragmentFlash;
import com.example.capstone.fragment.FragmentSendMessage;
import com.example.capstone.fragment.TabFragment;
import com.example.capstone.helper.ObjectPrefHelper;
import com.example.capstone.helper.PrefHelper;
import com.example.capstone.model.BoardModel;
import com.example.capstone.model.NavDrawerItem;
import com.example.capstone.view.RoundImageView;
import com.kakao.APIErrorResult;
import com.kakao.LogoutResponseCallback;
import com.kakao.MeResponseCallback;
import com.kakao.UnlinkResponseCallback;
import com.kakao.UpdateProfileResponseCallback;
import com.kakao.UserManagement;
import com.kakao.UserProfile;
import com.kakao.helper.Logger;
import com.kakao.widget.ProfileLayout;

public class UsermgmtMainActivity extends FragmentActivity {
	private UserProfile userProfile;
	private ProfileLayout profileLayout;
	private ExtraUserPropertyLayout extraUserPropertyLayout;

	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private RelativeLayout mDrawerLinear;
	private ActionBarDrawerToggle mDrawerToggle;

	private CharSequence mDrawerTitle;

	// used to store app title
	private CharSequence mTitle;

	// slide menu items
	private String[] navMenuTitles;
	private TypedArray navMenuIcons;

	private ArrayList<NavDrawerItem> navDrawerItems;
	private NavDrawerListAdapter adapter;
	private final String TAG = "saltfactory.net";
	private RoundImageView imageViewprofile;
	private TextView textViewNickName;

	private PrefHelper prefHelper;

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mTitle = mDrawerTitle = getTitle();
		prefHelper = CapstoneApplication.getGlobalApplicationContext().getPrefHelper();
		// load slide menu items
		navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);

		// nav drawer icons from resources
		navMenuIcons = getResources()
				.obtainTypedArray(R.array.nav_drawer_icons);

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerLinear = (RelativeLayout) findViewById(R.id.left_drawer);
		mDrawerList = (ListView) findViewById(R.id.list_slidermenu);
		// ImageView for Kakao profile
		imageViewprofile = (RoundImageView) findViewById(R.id.sf_imageview_profile);
		textViewNickName = (TextView) findViewById(R.id.text);
		// myimg.setImageResource(R.drawable.sampleprofile);
		// myimg.setImageResource(R.drawable.sampleprofile);

		navDrawerItems = new ArrayList<NavDrawerItem>();

		// adding nav drawer items to array
		// Home
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[0], navMenuIcons
				.getResourceId(0, -1)));
		// Find People
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[1], navMenuIcons
				.getResourceId(1, -1)));
		// Photos
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[2], navMenuIcons
				.getResourceId(2, -1)));
		// Communities, Will add a counter here
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[3], navMenuIcons
				.getResourceId(3, -1)));
		// Find Hospital
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[4], navMenuIcons
				.getResourceId(4, -1)));
		// Setting
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[5], navMenuIcons
				.getResourceId(5, -1)));
		// 게시판
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[6], navMenuIcons
				.getResourceId(6, -1)));

		// Recycle the typed array
		navMenuIcons.recycle();

		mDrawerList.setOnItemClickListener(new SlideMenuClickListener());

		// setting the nav drawer list adapter
		adapter = new NavDrawerListAdapter(getApplicationContext(),
				navDrawerItems);
		mDrawerList.setAdapter(adapter);

		// enabling action bar app icon and behaving it as toggle button
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, // nav menu toggle icon
				R.string.app_name, // nav drawer open - description for
									// accessibility
				R.string.app_name // nav drawer close - description for
									// accessibility
		) {
			public void onDrawerClosed(View view) {
				getActionBar().setTitle(mTitle);
				// calling onPrepareOptionsMenu() to show action bar icons
				invalidateOptionsMenu();

			}

			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle(mDrawerTitle);
				// calling onPrepareOptionsMenu() to hide action bar icons
				invalidateOptionsMenu();

			}
		};
		mDrawerLayout.setDrawerListener(mDrawerToggle);
		// set color trans whild drawer is open
		mDrawerLayout.setScrimColor(this.getResources().getColor(
				R.color.mytrans));

		if (savedInstanceState == null) {
			// on first time display view for first nav item
			displayView(0);
		}

		kakaoRequestProfile();
		// 카카오스토리 API 중에 프로파일 요청을 하기 위해서 KakaoStoryService.requestProfile()을
		// 호출한다.
		// 이 때 결과응답을 처리하 수 있도록 KakaoStoryHttpResponsehandler 구현체를 보내어 요청한다.
		// KakaoStoryService.requestProfile(new
		// KakaoStoryHttpResponseHandler<KakaoStoryProfile>() {
		// /**
		// * 카카오 세션의 유저와 같지 않을 때, 즉 카카오스토리 계정으로 로그인 되지 않은 경우
		// */
		// @Override
		// protected void onNotKakaoStoryUser() {
		// // final Intent intent = new Intent(UsermgmtMainActivity.this,
		// UserMgmtLoginActivity.class);
		// // startActivity(intent);
		// // finish();
		// Log.e("ERROR", "onNotKakaoStoryUser");
		// }
		//
		// /**
		// * 카카오스토리 requestProfile 요청이 실패하였을 경우
		// * @param errorResult 실패한 원인이 담긴 결과
		// */
		// @Override
		// protected void onFailure(APIErrorResult errorResult) {
		// Log.e(TAG, errorResult.toString());
		// }
		//
		// /**
		// * 카카오스토리 requestProfile 요청을 성공하였을 경우 KakaoStoryProfile 객체를 받아오게 된다.
		// * KakaoStoryProfile 객체 안에 프로파일 이미지, 배경이미지, 닉네임, 생일 정보가 들어 있다.
		// * @param kakaoStoryProfile
		// */
		// @Override
		// protected void onHttpSuccess(KakaoStoryProfile kakaoStoryProfile) {
		//
		// String profileImageURL = kakaoStoryProfile.getProfileImageURL();
		// Log.d(TAG, "KakaoStory profileImageURL : " + profileImageURL);
		// if (profileImageURL != null) {
		// new DownloadImageTask(imageViewprofile).execute(profileImageURL);
		// }
		// String nickName = kakaoStoryProfile.getNickName();
		// textViewNickName.setText(nickName);
		//
		// }
		//
		// @Override
		// protected void onHttpSessionClosedFailure(APIErrorResult errorResult)
		// {
		// Log.e(TAG, errorResult.toString());
		// }
		// });
	}

	private void kakaoRequestProfile() {
		UserManagement.requestMe(new MeResponseCallback() {

			@Override
			protected void onSuccess(final UserProfile userProfile) {
				String profileImageURL = userProfile.getProfileImagePath();
				if (profileImageURL != null) {
					new DownloadImageTask(imageViewprofile).execute(profileImageURL);
				}
				String nickName = userProfile.getNickname();
				textViewNickName.setText(nickName);
				
				prefHelper.put(BoardModel.WHO_MADE, nickName);
				prefHelper.put(BoardModel.WHO_MADE_ID, String.valueOf(userProfile.getId()));
			}

			@Override
			protected void onNotSignedUp() {

			}

			@Override
			protected void onSessionClosedFailure(
					final APIErrorResult errorResult) {

			}

			@Override
			protected void onFailure(final APIErrorResult errorResult) {

			}
		});

	}

	private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
		ImageView bmImage;

		// int targetWidth = 50;
		// int targetHeight = 50;

		public DownloadImageTask(ImageView bmImage) {
			this.bmImage = bmImage;
		}

		protected Bitmap doInBackground(String... urls) {
			String urldisplay = urls[0];
			Bitmap mIcon11 = null;
			try {
				InputStream in = new java.net.URL(urldisplay).openStream();
				mIcon11 = BitmapFactory.decodeStream(in);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return mIcon11;
		}

		protected void onPostExecute(Bitmap result) {
			bmImage.setImageBitmap(result);
		}
	}

	/**
	 * Slide menu item click listener
	 * */
	private class SlideMenuClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// display view for selected nav drawer item
			displayView(position);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		// toggle nav drawer on selecting action bar app icon/title
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		FragmentManager fragmentManager = getSupportFragmentManager();
		switch (id) {
		case R.id.action_settings:
			return true;
			// case R.id.actionbar_call:
			// // Intent dialer= new Intent(Intent.ACTION_DIAL);
			// // startActivity(dialer);
			// Toast.makeText(getApplicationContext(),"Status Clicked",Toast.LENGTH_SHORT).show();
			// return true;
		case R.id.board:
			Fragment board = new FragmentBoard();
			fragmentManager.beginTransaction()
					.replace(R.id.frame_container, board).commit();
			setTitle(navMenuTitles[6]);
			return true;
		case R.id.actionbar_torch:
			Bundle args = new Bundle();
			args.putString("Menu", "You pressed done button.");
			Fragment detail = new FragmentFlash();
			detail.setArguments(args);
			fragmentManager.beginTransaction()
					.replace(R.id.frame_container, detail).commit();
			// Toast.makeText(getApplicationContext(),"Status Clicked",Toast.LENGTH_SHORT).show();
			setTitle(navMenuTitles[7]);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 1234 && resultCode == RESULT_OK) {
			String voice_text = data.getStringArrayListExtra(
					RecognizerIntent.EXTRA_RESULTS).get(0);
			Toast.makeText(getApplicationContext(), voice_text,
					Toast.LENGTH_LONG).show();
		}
	}

	/* *
	 * Called when invalidateOptionsMenu() is triggered
	 */
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// if nav drawer is opened, hide the action items
		// boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
		boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerLinear);

		// final boolean drawerOpen = mDrawerLayout.isDrawerOpen(drawerll);
		menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
		return super.onPrepareOptionsMenu(menu);
	}

	/**
	 * Diplaying fragment view for selected nav drawer list item
	 * */
	private void displayView(int position) {
		// update the main content by replacing fragments
		Fragment fragment = null;
		switch (position) {
		case 0:
			fragment = new FragmentEmergencyCall();
			break;
		case 1:
			fragment = new FragmentSendMessage();
			break;
		case 2:
			fragment = new TabFragment();
			break;
		case 3:
			fragment = new FragmentFakecall();
			break;
		case 4:
			fragment = new FragmentCommunity();
			break;
		case 5:
			Intent myintent = new Intent(this, Game.class);
			startActivity(myintent);
			// fragment = new FragmentFlash();
			break;
		case 6:
			fragment = new FragmentBoard();
		default:
			break;
		}
		if (fragment != null) {
			FragmentManager fragmentManager = getSupportFragmentManager();
			fragmentManager.beginTransaction()
					.replace(R.id.frame_container, fragment).commit();
			// update selected item and title, then close the drawer
			mDrawerList.setItemChecked(position, true);
			mDrawerList.setSelection(position);
			setTitle(navMenuTitles[position]);
			// mDrawerLayout.closeDrawer(mDrawerList);
			mDrawerLayout.closeDrawer(mDrawerLinear);
		}

		else {
			// error in creating fragment
		}
	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}

	/**
	 * When using the ActionBarDrawerToggle, you must call it during
	 * onPostCreate() and onConfigurationChanged()...
	 */

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Pass any configuration change to the drawer toggls
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	protected void onResume() {
		super.onResume();
		userProfile = UserProfile.loadFromCache();
		if (userProfile != null)
			showProfile();
	}

	private void redirectLoginActivity() {
		Intent intent = new Intent(this, UserMgmtLoginActivity.class);
		startActivity(intent);
		finish();
	}

	private void redirectSignupActivity() {
		Intent intent = new Intent(this, UsermgmtSignupActivity.class);
		startActivity(intent);
		finish();
	}

	private void onClickUpdateProfile() {
		final HashMap<String, String> properties = extraUserPropertyLayout
				.getProperties();

		UserManagement.requestUpdateProfile(
				new UpdateProfileResponseCallback() {
					@Override
					protected void onSuccess(final long userId) {
						UserProfile.updateUserProfile(userProfile, properties);
						if (userProfile != null)
							userProfile.saveUserToCache();
						Toast.makeText(getApplicationContext(),
								"succeeded to update user profile",
								Toast.LENGTH_SHORT).show();
						Logger.getInstance().d(
								"succeeded to update user profile"
										+ userProfile);
						showProfile();
					}

					@Override
					protected void onSessionClosedFailure(
							final APIErrorResult errorResult) {
						redirectLoginActivity();
					}

					@Override
					protected void onFailure(final APIErrorResult errorResult) {
						String message = "failed to update user profile. msg="
								+ errorResult;
						Logger.getInstance().d(message);
						Toast.makeText(getApplicationContext(), message,
								Toast.LENGTH_LONG).show();
					}
				}, properties);
	}

	private void onClickLogout() {
		UserManagement.requestLogout(new LogoutResponseCallback() {
			@Override
			protected void onSuccess(final long userId) {
				redirectLoginActivity();
			}

			@Override
			protected void onFailure(final APIErrorResult apiErrorResult) {
				Logger.getInstance().d(
						"failed to sign up. msg=" + apiErrorResult);
				redirectLoginActivity();
			}
		});
	}

	private void onClickUnlink() {
		final String appendMessage = getString(R.string.com_kakao_confirm_unlink);
		new AlertDialog.Builder(this)
				.setMessage(appendMessage)
				.setPositiveButton(getString(R.string.com_kakao_ok_button),
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								UserManagement
										.requestUnlink(new UnlinkResponseCallback() {
											@Override
											protected void onSuccess(
													final long userId) {
												redirectLoginActivity();
											}

											@Override
											protected void onSessionClosedFailure(
													final APIErrorResult errorResult) {
												redirectLoginActivity();
											}

											@Override
											protected void onFailure(
													final APIErrorResult errorResult) {
												Logger.getInstance().d(
														"failure to unlink. msg = "
																+ errorResult);
												redirectLoginActivity();
											}
										});
								dialog.dismiss();
							}
						})
				.setNegativeButton(getString(R.string.com_kakao_cancel_button),
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								dialog.dismiss();
							}
						}).show();

	}

	private void showProfile() {
		if (profileLayout != null)
			profileLayout.setUserProfile(userProfile);
		if (extraUserPropertyLayout != null)
			extraUserPropertyLayout.showProperties(userProfile.getProperties());
	}

	private void initializeView() {
		setContentView(R.layout.main);
		initializeButtons();
		initializeProfileView();
	}

	private void initializeButtons() {
		final Button buttonMe = (Button) findViewById(R.id.buttonMe);
		buttonMe.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				profileLayout.requestMe();
			}
		});

		final Button buttonUpdateProfile = (Button) findViewById(R.id.buttonUpdateProfile);
		buttonUpdateProfile.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				onClickUpdateProfile();
			}
		});

		final Button logoutButton = (Button) findViewById(R.id.logout_button);
		logoutButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				onClickLogout();
			}
		});

		final Button unlinkButton = (Button) findViewById(R.id.unlink_button);
		unlinkButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				onClickUnlink();
			}
		});
	}

	private void initializeProfileView() {
		profileLayout = (ProfileLayout) findViewById(R.id.com_kakao_user_profile);
		profileLayout.setMeResponseCallback(new MeResponseCallback() {
			@Override
			protected void onSuccess(final UserProfile userProfile) {
				Toast.makeText(getApplicationContext(),
						"succeeded to get user profile", Toast.LENGTH_SHORT)
						.show();
				if (userProfile != null) {
					UsermgmtMainActivity.this.userProfile = userProfile;
					userProfile.saveUserToCache();
					showProfile();
				}
			}

			@Override
			protected void onNotSignedUp() {
				redirectSignupActivity();
			}

			@Override
			protected void onSessionClosedFailure(
					final APIErrorResult errorResult) {
				redirectLoginActivity();
			}

			@Override
			protected void onFailure(final APIErrorResult errorResult) {
				String message = "failed to get user info. msg=" + errorResult;
				Logger.getInstance().d(message);
				Toast.makeText(getApplicationContext(), message,
						Toast.LENGTH_LONG).show();
			}
		});

		extraUserPropertyLayout = (ExtraUserPropertyLayout) findViewById(R.id.extra_user_property);
	}
}
