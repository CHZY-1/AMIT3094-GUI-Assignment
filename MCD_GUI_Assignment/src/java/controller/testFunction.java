package controller;

public class testFunction{

    public testFunction() {
    }
    
    public static void main(String args [ ]){
        
        String addressID = "PD-14";
        
       String[] id = addressID.split("-");
       int no=Integer.parseInt(id[1]);
        no++;
        //(int)id[1]=Integer.parseInt(id[1])+1;
        String seq = String.format("%03d", no);
        String AID=id[0]+"-"+seq;
        
        System.out.println(AID);
        System.out.println(seq);
    }
}