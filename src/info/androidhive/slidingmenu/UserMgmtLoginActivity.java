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

import android.content.Intent;
import android.os.Bundle;

import com.kakao.template.loginbase.SampleLoginActivity;

public class UserMgmtLoginActivity extends SampleLoginActivity {
	//private LoginButton loginButton;
   // private final SessionCallback mySessionCallback = new MySessionStatusCallback();
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBackground(getResources().getDrawable(R.drawable.usermgmt_sample_login_background));
        //  loginButton = (LoginButton) findViewById(R.id.com_kakao_login);

       
    }

	@Override
  /*  protected void onResume() {
        super.onResume();
        // �꽭�뀡�쓣 珥덇린�솕 �븳�떎. 移댁뭅�삤�넚�쑝濡쒕쭔 濡쒓렇�씤�쓣 �쑀�룄�븯怨� �떢�떎硫� Session.initializeSession(this, mySessionCallback, AuthType.KAKAO_TALK)
        if(Session.initializeSession(this, mySessionCallback)){
            // 1. �꽭�뀡�쓣 媛깆떊 以묒씠硫�, �봽濡쒓렇�젅�뒪諛붾�� 蹂댁씠嫄곕굹 踰꾪듉�쓣 �닲湲곕뒗 �벑�쓽 �븸�뀡�쓣 痍⑦븳�떎
            loginButton.setVisibility(View.GONE);
        } else if (Session.getCurrentSession().isOpened()){
            // 2. �꽭�뀡�씠 �삤�뵂�맂�맂 �긽�깭�씠硫�, �떎�쓬 activity濡� �씠�룞�븳�떎.
            onSessionOpened();
        }
            // 3. else 濡쒓렇�씤 李쎌씠 蹂댁씤�떎.
    }

    private class MySessionStatusCallback implements SessionCallback {
        @Override
        public void onSessionOpened() {
            // �봽濡쒓렇�젅�뒪諛붾�� 蹂댁씠怨� �엳�뿀�떎硫� 以묒��븯怨� �꽭�뀡 �삤�뵂�썑 蹂댁씪 �럹�씠吏�濡� �씠�룞
        	FirstActivity.this.onSessionOpened();
        }


		@Override
		public void onSessionClosed(KakaoException exception) {
			// TODO Auto-generated method stub
			loginButton.setVisibility(View.VISIBLE);
		}

    }*/

    /**
     * �꽭�뀡�씠 �삤�뵂�릺�뿀�쑝硫� 媛��엯�럹�씠吏�濡� �씠�룞
     */
    
    protected void onSessionOpened() {
        final Intent intent = new Intent(UserMgmtLoginActivity.this, UsermgmtSignupActivity.class);
        startActivity(intent);
        finish();
    }
}
