package com.example.capstone.fragment;

import info.androidhive.slidingmenu.R;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class FragmentHospital extends Fragment implements AdapterView.OnItemSelectedListener
{
	
	String[] first_spinner = {"강원", "경기","경상남도", "경상북도","광주", "대구", "대전","부산","서울","울산", "인천", "전라남도","전라북도","제주","충청남도","충청북도"};

//	String[] kangwon = {"강릉시", "고성군","동해시","삼척시", "속초시","양구군", "양양군", "영월군","원주시", "인제군","정선군", "철원군", "춘천시","태백시", "평창군","홍천군", "화천군", "횡성군"};
//	String[] Gyeonggi = {"가평군", "고양시 덕양구","고양시 일산동구","고양시 일산서구", "과천시","광명시", "광주시", "구리시","군포시","김포시", "남양주시","동두천시","부천시 소사구", "부천시 오정구","부천시 원미구", "성남시 분당구", "성남시 수정구","성남시 중원구","수원시 권선구", "수원시 영통구","수원시 장안구","수원시 팔달구", "시흥시","안산시 단원구", "안산시 상록구", "안성시","안양시 동안구","안양시 민안구", "양주시","양평군","여주군", "오산시","용인시 기흥구", "용인시 수지구", "용인시 처인구","의왕시","의정부시", "이천시","파주시","평택시", "포천시","하남시", "화성시"};
//	String[] Gyeongnam = {"거제시", "거창군","고성군","김해시", "남해군","밀양시", "사천시", "산청군","양산시","의령군", "진주시","창녕군","창원시 마산합포구", "창원시 마산회원구","창원시 성산구", "창원시 의창구", "창원시 진해구","통영시","하동군", "함안군","함양군","합천군"};
//	String[] Gyeongbuk = {"경상시", "경주시","고령군","구미시", "군위군","김천시", "문경시", "봉화군","상주시","성주군", "안동시","영덕군","영양군", "영주시","영천군", "예천군", "울릉군","울진군","의성군", "청도군", "칠곡군","포항시 남구","포항시 북구"};
//	String[] Gyuangju = {"광산구", "남구","동구","북구", "서구"};
//	String[] Daegu = {"남구", "달서구","달성군","동구", "북구","서구", "수성구", "중구"};
//	String[] Daejeon = {"대덕구", "동구","서구","유성구", "중구"};
//	String[] Busan = {"강서구", "금정구","기장군","남구", "동구","동래구", "부산진구", "북구","사상구","사하구", "서구","수영구","연제구", "영도구","중구", "해운대구"};
//	String[] Seoul = {"강남구", "강동구","강북구","강서구", "관악구","광진구", "구로구", "금천구","노원구","도봉구", "동대문구","동작구","마포구", "서대문구","서초구", "성동구", "성북구","송파구","양천구", "영등포구","용산구","은평구", "종로구","중구", "중랑구"};
//	String[] Ulsan = {"남구", "동구","북구","울주군", "중구"};
//	String[] Incheon = {"강화군", "계양구","남구","남동구", "동구","부평구", "서구", "연수구","옹진군","중구"};
//	String[] Jeonnam = {"강진군", "고흥군","곡성군","광양시", "구례군","나주시", "담양군", "목포시","무안군","보성군","순천시","신안군","여수시","영광군","영암군","완도군","장성군","장흥군","진도군","함평군","해남군","화순군"};
//	String[] Jeonbuk = {"고창군", "군산시","김제시","남원시", "무주군","부안군", "순창군", "완주군","익산시","임실군", "장수군","전주시 덕진구","전주시 완산구", "정읍시","진안군"};
//	String[] Jeju = {"서귀포시", "제주시"};
//	String[] Chungnam = {"계룡시", "공주시","금산군","논산시", "당진시","보령시", "부여군", "서산시","서천군","아산시", "예산군","천안시 동남구","천안시 서북구", "청양군","태안군", "홍성군"};
//	String[] Chungbuk = {"괴산군", "단양군","보은군","영동군", "옥천군","음성군", "제천시", "증평군","진천군","청원군","청주시 상당구","청주시 흥덕구", "충주시"};

	Spinner spin0, spin1, spin2, spin3, spin4, spin5, spin6, spin7, spin8, spin9,spin10, spin11, spin12, spin13, spin14, spin15, spin16;
	Context thiscontext;
	public FragmentHospital(){}
	
	@Override
    public final View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_hospital, container, false);
        thiscontext = container.getContext();
        ///Choose Category On First Spinner
        spin0 = (Spinner)rootView.findViewById(R.id.spinner1);
        //To hear What User choose On First Spinner
        spin0.setOnItemSelectedListener((OnItemSelectedListener) this);
        ArrayAdapter <String> c = new ArrayAdapter <String> (thiscontext,android.R.layout.simple_spinner_item,first_spinner);
        c.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin0.setAdapter(c);
        
//        chooseCity1(rootView);
//        chooseCity2(rootView);
//        chooseCity3(rootView);
//        chooseCity4(rootView);
//        chooseCity5(rootView);
//        chooseCity6(rootView);
//        chooseCity7(rootView);
//        chooseCity8(rootView);
//        chooseCity9(rootView);
//        chooseCity10(rootView);
//        chooseCity11(rootView);
//        chooseCity12(rootView);
//        chooseCity13(rootView);
//        chooseCity14(rootView);
//        chooseCity15(rootView);
//        chooseCity16(rootView);
        
        spin1.setOnItemSelectedListener((OnItemSelectedListener) this);
        spin1.setEnabled(false);
        return rootView;
    }

	/*private void chooseCity1(View myrootView){
        spin1 = (Spinner)myrootView.findViewById(R.id.spinner2);
        List<String> city1 = new ArrayList<String>();
        city1.add("test1");
        city1.add("test2");
        ArrayAdapter<String> cityAdapter1 = new ArrayAdapter<String>(thiscontext, android.R.layout.simple_spinner_item, city1);
        cityAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(cityAdapter1);
	}
	private void chooseCity2(View myrootView){
        spin2 = (Spinner)myrootView.findViewById(R.id.spinner2);
        List<String> city2 = new ArrayList<String>();
        city2.add("test1");
        city2.add("test2");
        ArrayAdapter<String> cityAdapter1 = new ArrayAdapter<String>(thiscontext, android.R.layout.simple_spinner_item, city1);
        cityAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(cityAdapter1);
	}
	private void chooseCity1(View myrootView){
        spin1 = (Spinner)myrootView.findViewById(R.id.spinner2);
        List<String> city1 = new ArrayList<String>();
        city1.add("test1");
        city1.add("test2");
        ArrayAdapter<String> cityAdapter1 = new ArrayAdapter<String>(thiscontext, android.R.layout.simple_spinner_item, city1);
        cityAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(cityAdapter1);
	}
	private void chooseCity1(View myrootView){
        spin1 = (Spinner)myrootView.findViewById(R.id.spinner2);
        List<String> city1 = new ArrayList<String>();
        city1.add("test1");
        city1.add("test2");
        ArrayAdapter<String> cityAdapter1 = new ArrayAdapter<String>(thiscontext, android.R.layout.simple_spinner_item, city1);
        cityAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(cityAdapter1);
	}
	private void chooseCity1(View myrootView){
        spin1 = (Spinner)myrootView.findViewById(R.id.spinner2);
        List<String> city1 = new ArrayList<String>();
        city1.add("test1");
        city1.add("test2");
        ArrayAdapter<String> cityAdapter1 = new ArrayAdapter<String>(thiscontext, android.R.layout.simple_spinner_item, city1);
        cityAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(cityAdapter1);
	}
	private void chooseCity1(View myrootView){
        spin1 = (Spinner)myrootView.findViewById(R.id.spinner2);
        List<String> city1 = new ArrayList<String>();
        city1.add("test1");
        city1.add("test2");
        ArrayAdapter<String> cityAdapter1 = new ArrayAdapter<String>(thiscontext, android.R.layout.simple_spinner_item, city1);
        cityAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(cityAdapter1);
	}
	private void chooseCity1(View myrootView){
        spin1 = (Spinner)myrootView.findViewById(R.id.spinner2);
        List<String> city1 = new ArrayList<String>();
        city1.add("test1");
        city1.add("test2");
        ArrayAdapter<String> cityAdapter1 = new ArrayAdapter<String>(thiscontext, android.R.layout.simple_spinner_item, city1);
        cityAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(cityAdapter1);
	}
	private void chooseCity1(View myrootView){
        spin1 = (Spinner)myrootView.findViewById(R.id.spinner2);
        List<String> city1 = new ArrayList<String>();
        city1.add("test1");
        city1.add("test2");
        ArrayAdapter<String> cityAdapter1 = new ArrayAdapter<String>(thiscontext, android.R.layout.simple_spinner_item, city1);
        cityAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(cityAdapter1);
	}
	private void chooseCity1(View myrootView){
        spin1 = (Spinner)myrootView.findViewById(R.id.spinner2);
        List<String> city1 = new ArrayList<String>();
        city1.add("test1");
        city1.add("test2");
        ArrayAdapter<String> cityAdapter1 = new ArrayAdapter<String>(thiscontext, android.R.layout.simple_spinner_item, city1);
        cityAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(cityAdapter1);
	}
	
        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,long arg3) {

            spin1.setEnabled(true);
                        if(spin0.getSelectedItem().equals("강원"))
                        {
                            ArrayAdapter <String> s1 = new ArrayAdapter <String> (thiscontext,android.R.layout.simple_spinner_item,kangwon);
                            s1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spin1.setAdapter(s1);
                        }
                        else  if(spin0.getSelectedItem().equals("경기"))
                        {
                            ArrayAdapter <String> s2 = new ArrayAdapter <String> (thiscontext,android.R.layout.simple_spinner_item,Gyeonggi);
                            s2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spin1.setAdapter(s2);
                        }
                        else  if(spin0.getSelectedItem().equals("경상남도"))
                        {
                            ArrayAdapter <String> s3 = new ArrayAdapter <String> (thiscontext,android.R.layout.simple_spinner_item,Gyeongnam);
                            s3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spin1.setAdapter(s3);
                        }
                        else  if(spin0.getSelectedItem().equals("경상북도"))
                        {
                            ArrayAdapter <String> s4 = new ArrayAdapter <String> (thiscontext,android.R.layout.simple_spinner_item,Gyeongbuk);
                            s4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spin1.setAdapter(s4);
                        }
                        else  if(spin0.getSelectedItem().equals("광주"))
                        {
                            ArrayAdapter <String> s5 = new ArrayAdapter <String> (thiscontext,android.R.layout.simple_spinner_item,Gyuangju);
                            s5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spin1.setAdapter(s5);
                        }
                        else  if(spin0.getSelectedItem().equals("대구"))
                        {
                            ArrayAdapter <String> s6 = new ArrayAdapter <String> (thiscontext,android.R.layout.simple_spinner_item,Daegu);
                            s6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spin1.setAdapter(s6);
                        }
                        else  if(spin0.getSelectedItem().equals("대전"))
                        {
                            ArrayAdapter <String> s7 = new ArrayAdapter <String> (thiscontext,android.R.layout.simple_spinner_item,Daejeon);
                            s7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spin1.setAdapter(s7);
                        }
                        else  if(spin0.getSelectedItem().equals("부산"))
                        {
                            ArrayAdapter <String> s8 = new ArrayAdapter <String> (thiscontext,android.R.layout.simple_spinner_item,Busan);
                            s8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spin1.setAdapter(s8);
                        }
                        else  if(spin0.getSelectedItem().equals("서울"))
                        {
                            ArrayAdapter <String> s9 = new ArrayAdapter <String> (thiscontext,android.R.layout.simple_spinner_item,Seoul);
                            s9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spin1.setAdapter(s9);
                        }
                        else  if(spin0.getSelectedItem().equals("울산"))
                        {
                            ArrayAdapter <String> s10 = new ArrayAdapter <String> (thiscontext,android.R.layout.simple_spinner_item,Ulsan);
                            s10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spin1.setAdapter(s10);
                        }
                        else  if(spin0.getSelectedItem().equals("인천"))
                        {
                            ArrayAdapter <String> s11 = new ArrayAdapter <String> (thiscontext,android.R.layout.simple_spinner_item,Incheon);
                            s11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spin1.setAdapter(s11);
                        }
                        else  if(spin0.getSelectedItem().equals("전라남도"))
                        {
                            ArrayAdapter <String> s12 = new ArrayAdapter <String> (thiscontext,android.R.layout.simple_spinner_item,Jeonnam);
                            s12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spin1.setAdapter(s12);
                        }
                        else  if(spin0.getSelectedItem().equals("전라북도"))
                        {
                            ArrayAdapter <String> s13 = new ArrayAdapter <String> (thiscontext,android.R.layout.simple_spinner_item,Jeonbuk);
                            s13.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spin1.setAdapter(s13);
                        }else  if(spin0.getSelectedItem().equals("제주"))
                        {
                            ArrayAdapter <String> s14 = new ArrayAdapter <String> (thiscontext,android.R.layout.simple_spinner_item,Jeju);
                            s14.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spin1.setAdapter(s14);
                        }
                        else  if(spin0.getSelectedItem().equals("충청남도"))
                        {
                            ArrayAdapter <String> s15 = new ArrayAdapter <String> (thiscontext,android.R.layout.simple_spinner_item,Chungnam);
                            s15.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spin1.setAdapter(s15);
                        }
                        else  if(spin0.getSelectedItem().equals("충청북도"))
                        {
                            ArrayAdapter <String> s16 = new ArrayAdapter <String> (thiscontext,android.R.layout.simple_spinner_item,Chungbuk);
                            s16.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spin1.setAdapter(s16);
                        }
                      
*/
       // }    
        public void onNothingSelected(AdapterView<?> arg0) {                

        }

		@Override
		public void onItemSelected(AdapterView<?> parent, View view,
				int position, long id) {
			// TODO Auto-generated method stub
			
		}
       
}
