package sample;

import com.sun.org.apache.regexp.internal.RE;

import java.io.*;
import java.util.ArrayList;

public class SLfile {
    public ArrayList<Request> listRequest;
    public ArrayList<Aggregate> listAggregate;

    public void SaveRequest(ArrayList<Request> requests){
        try{
            FileOutputStream fos= new FileOutputStream("requests");
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            oos.writeObject(requests);
            oos.close();
            fos.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }

    }
    public ArrayList<Request> LoadRequest(){
        listRequest= new ArrayList<Request>();
        try
        {
            FileInputStream fis = new FileInputStream("requests");
            ObjectInputStream ois = new ObjectInputStream(fis);
            listRequest = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
            return listRequest;
        }catch(IOException ioe){
            ioe.printStackTrace();
            return listRequest;
        }catch(ClassNotFoundException c){
            System.out.println("Class not found");
            c.printStackTrace();
            return listRequest;
        }
    }
    public void SaveAggregate(ArrayList<Aggregate> aggregates){
        try{
            FileOutputStream fos= new FileOutputStream("aggregates");
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            oos.writeObject(aggregates);
            oos.close();
            fos.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }

    }
    public ArrayList<Aggregate> LoadAggregate(){
            listAggregate= new ArrayList<Aggregate>();
        try
        {
            FileInputStream fis = new FileInputStream("aggregates");
            ObjectInputStream ois = new ObjectInputStream(fis);
            listRequest = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
            return listAggregate;
        }catch(IOException ioe){
            ioe.printStackTrace();
            return listAggregate;
        }catch(ClassNotFoundException c){
            System.out.println("Class not found");
            c.printStackTrace();
            return listAggregate;
        }
    }


}
