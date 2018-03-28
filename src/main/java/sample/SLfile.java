package sample;

import com.sun.org.apache.regexp.internal.RE;

import java.io.*;
import java.util.ArrayList;

public class SLfile {
    ArrayList<Request> listRequest;
    public void Save(ArrayList<Request> requests){
        try{
            FileOutputStream fos= new FileOutputStream("Request");
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            oos.writeObject(requests);
            oos.close();
            fos.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }

    }
    public void Load(){
        listRequest= new ArrayList<Request>();
        try
        {
            FileInputStream fis = new FileInputStream("myfile");
            ObjectInputStream ois = new ObjectInputStream(fis);
            listRequest = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
            return;
        }catch(ClassNotFoundException c){
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
        for(Request tmp:listRequest){
            for(Document_item i:tmp.getItems()){
                System.out.println(i.getValue());
            }
        }
    }


}
