
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;




public class Main {
	
	Map<String, Object> session=new HashMap<>();
	void testWarnings(){
		ArrayList<Actor> actor=(ArrayList<Actor>)session.get("user");
		if (session.get("user") instanceof ArrayList<?>){
			actor=(ArrayList<Actor>)session.get("user");
		}
	}
	
	static public  void main(String [] args) throws IOException, InvalidFormatException{
		final String username = "liliaqwer@gmail.com";
        final String password = "120986qwer";

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse("Karavaichik@irc.beltelecom.by"));
            message.setSubject("Testing Subject");
            message.setText("Dear Mail Crawler,"
                + "\n\n No spam to my email, please!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
		
		try{
		System.out.println(" десять");
		}catch(Exception e){
			
		}
		ExcelInfo inf=new ExcelInfo();
		inf.fio="";
		inf.phone=12l;
		System.out.println( 5 + 5 + " десять");
		System.out.println("десять "+ 5 + 5);
		System.out.println(5 + " десять " + 5);
		System.out.println("десять " + (5 + 5));
		System.out.println("" + 5 + 5 + " десять");
		Integer i1=1000;
		Integer ii=1000;
		System.out.println(i1==ii);
		ArrayList<Integer> listik=new ArrayList<>();
		listik.add(1);
		listik.add(10);
		listik.add(5);
		listik.add(7);
		HashMap<String, HashMap<String, ExcelInfo>> map=new HashMap<>();
		ArrayList<Integer> listik2=new ArrayList<>();		
		listik2.addAll(listik);
		for(Integer a:listik ){
			System.out.println("*"+a);
		}
		//ArrayList<Integer> list=new ArrayList<>(2);
		System.out.println("LIST");
		//list.add(10);
		//list.add(5);
		//list.add(1, 7);
		int a=1;
		a=a++;
		System.out.println(a);
		switch(a){
		default:System.out.println("sys");
		case 2:System.out.println("z");
		case 3:System.out.println("c");
		}
		Integer [] ar= new Integer[listik.size()];
		int[][] arr={{1,2,3}, {0,0,0}, {3,2,1}}; 
		int i2[]=new int[2]; 
		for (int i[] : arr) { 
		    for (int j : i) 
		        System.out.print(j + " "); 
		    System.out.println(); 
		} 
		listik.toArray(ar);
		Arrays.sort(ar,new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1>o2) return -1;
				if(o1<o2) return 1;
				return 0;
			}
		} );
		for(Integer i:ar){
			System.out.println(i);
		}
		ExcelInfo obj=new ExcelInfo("1",100);
		ArrayList<ExcelInfo> list=new ArrayList<>();
		list.add(obj);
		obj=new ExcelInfo("1",100);
		list.add(obj);
		obj=new ExcelInfo("2",100);
		list.add(obj);
		obj=new ExcelInfo("3",200);
		list.add(obj);
		obj=new ExcelInfo("3",400);
		list.add(obj);
		obj=new ExcelInfo("1",100);
		list.add(obj);
		obj=new ExcelInfo("5",100);
		list.add(obj);
		System.out.println("первоначальный");
		for(ExcelInfo info:list){
			System.out.println(info.toString());
		}
		System.out.println("итоговый");
		ArrayList<ExcelInfo> resultList=masssum(list,+1);
		for(ExcelInfo info:resultList){
			System.out.println(info.toString());
		}
		/* InputStream file = new FileInputStream(n
		 * ew File("c:\\java\\MOBIL_DETAIL062013.xls"));
		 //Workbook workbook = 
		 new XSSFWorkbook(file);
		//FileInputStream fileInputStream = new FileInputStream(new File("c:\\java\\m.xlsx"));
		// XSSFWorkbook xssfWorkBook = new XSSFWorkbook(opcPackage);
		      ZipFile zf = new ZipFile("c:\\java\\M.zip");
		      Enumeration entries = zf.entries();
		      InputStream inp=null ;
		      while (entries.hasMoreElements()) {
		        ZipEntry ze = (ZipEntry) entries.nextElement();
		        System.out.println("Read " + ze.getName() + "?");
		        inp = zf.getInputStream(ze);
		       
		          }
		        
		     
		   
		  
		try {
			//LinkedHashMap<Long,ExcelInfo> map=new LinkedHashMap<Long, ExcelInfo>();
			boolean isEnd=false;
			boolean isBegin=false;
			int beginRowNum=0;
			//InputStream inp = new FileInputStream(new File("c:\\java\\01.07.2014.xls"));
			Workbook  wb=null;
			try{
				wb = new HSSFWorkbook(inp);
			}catch(Exception e){
				//e.printStackTrace();
				try{
					wb = new XSSFWorkbook(inp);
				}catch(Exception ex){
					System.out.println("2");
					ex.printStackTrace();
					throw new Exception("Не является .xls файлом");
				}
			}	
			Sheet  sheet;
			for(int i=0;i<=4;i++){
				try{
					sheet = wb.getSheetAt(i);
					System.out.println("Лист "+i);
				}catch (Exception e){
					e.printStackTrace();
					break;
				}
				for (Row row : sheet) {					
				   	if (row.getRowNum()<2) continue;	
				   	System.out.println("Строка "+row.getRowNum());
				    ExcelInfo obj=new ExcelInfo();
				    for (Cell cell : row) {	 
				    	if (cell.getColumnIndex()>3) break;
				        switch (cell.getColumnIndex()){				    		
				    		case 1:
				    			try{
				    				obj.setPhone(Long.parseLong(cell.getStringCellValue().substring(0, 12)));
				    			}catch (Exception e) {
									isEnd=true;
								}
				    			break;
				    		case 3: 
				    			obj.setFio(cell.getStringCellValue());
				       		//System.out.println(cell);
				    			break;
				        		case 4:		        		
				    	}	
				        if (isEnd) break;				       
				     }
				     if (isEnd){
				       	break;
				     }else{
				    	System.out.println(obj.getPhone()+" "+obj.getFio());
				       	//map.put(obj.getPhone(), obj);
				     }
				}
				//Set<Long> phones=map.keySet(); 
				//System.out.println("Итого в листе:");
				//for (Long phone:phones){
				//	System.out.println(map.get(phone).toString());
				//}
			}
			   
			inp.close();zf.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}

	 public static ArrayList<ExcelInfo> masssum(ArrayList<ExcelInfo> listMass, int testParam) {
		 
		 int param=testParam;
		 System.out.println("p="+param);
		 /* ArrayList<ExcelInfo> listMegamass = new ArrayList<>();
		  boolean exist=false;
		  for (int i = 0; i < listMass.size(); i++) {			  
			   for (int j = 0; j < listMegamass.size(); j++) {
		    	 if (listMass.get(i).getFio().equals(listMegamass.get(j).getFio())) {
		    		exist=true;
		    		listMegamass.get(j).setPhone(listMegamass.get(j).getPhone()+ listMass.get(i).getPhone());
		    	} 
		    }
		    if (!exist){
		    	
		    	 listMegamass.add(listMass.get(i));
		    }
		   }
		 
		  return listMegamass;*/
		 ArrayList<ExcelInfo> listMegamass = new ArrayList<>();
		  for (int i = 0; i < listMass.size(); i++) {
			  //System.out.println("i: "+i+" fio="+listMass.get(i).getFio()+ " summ="+listMass.get(i).getPhone());
		   if (i == 0) {
		    listMegamass.add(listMass.get(i));
		   } else {		    
		    for (int j = 0; j < listMegamass.size(); j++) {
		    	 //System.out.println("j: "+j+" fio="+listMegamass.get(j).getFio()+ " summ="+listMegamass.get(j).getPhone());
		     if  (listMass.get(i).getFio().equals(listMegamass.get(j).getFio())){
		    	 listMegamass.get(j).setPhone(listMegamass.get(j).getPhone()+ listMass.get(i).getPhone());
		    	// System.out.println("plus");
		      break;

		     }
		    // System.out.println("not plus");
		     if (j == listMegamass.size() - 1) {
		    	// System.out.println("add");
		      listMegamass.add(listMass.get(i));
		      break;
		     }
		    }
		   }
		  }
		  return listMegamass;
		 }
}
