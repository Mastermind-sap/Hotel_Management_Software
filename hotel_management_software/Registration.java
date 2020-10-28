import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
class Registration
{public static void main()
    { System.out.println("");
        System.out.println("\t\t\t\t\t\t\t\t\tRegistration");
        System.out.println("\t\t\t\t\t\t\t\t\t************");
        System.out.println("");
        Hotel_Management_Software ob=new Hotel_Management_Software();
        Scanner sc=new Scanner(System.in);

        System.out.println("enter number of guests");    //Input for number of guests to be registered
        int g=0;int n1=0;
        while(g==0)
        {   String num=sc.next();
            num+=sc.nextLine();
            try
            { n1=Integer.parseInt(num);
            }catch(Exception e)
            {
            }
            if((n1==0)||(n1<1))
            {System.out.println("Invalid input");
                System.out.println("enter number of guests again");
            }
            else
                g=1;
        }    
        if(n1<=ob.remaining_rooms)
        {
            for(int i=(ob.no_rooms-ob.remaining_rooms),d=0;d<n1;i++,d++)
            {   ob.remaining_rooms=ob.remaining_rooms-1;
                System.out.println("enter name of the guest");   //input for the name of the guest to be registered
                ob.name[i]=sc.next();
                ob.name[i]+=sc.nextLine();

                int f=0;char choice='d';      //input for the gender of the guest to be registered
                do
                {System.out.println("enter 'M' if guest is a male\n      'F' if guest is a female");    
                    choice=sc.next().charAt(0);
                    choice=Character.toUpperCase(choice);
                    switch(choice)
                    {
                        case 'M':
                        ob.gender[i]="male";
                        f=1;
                        break;
                        case 'F':
                        ob.gender[i]="female";
                        f=1;
                        break;
                        default:
                        System.out.println("Invalid input");
                    }
                }while(f==0);

                System.out.println("enter age of the guest in years");  //input for the age of the guest to be registered
                int g1=0;
                while(g1==0)
                {   String d1=sc.next();
                    d1+=sc.nextLine();
                    try
                    { ob.age[i]=Integer.parseInt(d1);
                    }catch(Exception e)
                    {
                    }
                    if((ob.age[i]==0)||(ob.age[i]<1)||(ob.age[i]>110))
                    {System.out.println("Invalid age");
                        System.out.println("enter age of the guest again");
                    }
                    else
                        g1=1;
                }    

                System.out.println("enter address of the guest");   //input for the address of the guest to be registered
                ob.address[i]=sc.next();
                ob.address[i]+=sc.nextLine();
                System.out.println("enter PAN number of the guest");   //input for the PAN number of the guest to be registered
                int p=0;
                do
                {
                    ob.pan[i]=sc.next();
                    ob.pan[i]+=sc.nextLine();
                    ob.pan[i]=ob.pan[i].toUpperCase();
                    if((ob.pan[i].length()==10)&&(Character.isLetter(ob.pan[i].charAt(0)))&&(Character.isLetter(ob.pan[i].charAt(1)))
                    &&(Character.isLetter(ob.pan[i].charAt(2)))&&(Character.isLetter(ob.pan[i].charAt(3)))
                    &&(Character.isLetter(ob.pan[i].charAt(4)))&&(Character.isDigit(ob.pan[i].charAt(5)))
                    &&(Character.isDigit(ob.pan[i].charAt(6)))&&(Character.isDigit(ob.pan[i].charAt(7)))
                    &&(Character.isDigit(ob.pan[i].charAt(8)))&&(Character.isLetter(ob.pan[i].charAt(9))))
                        p=0;
                    else 
                    {System.out.println("invalid PAN number");
                        System.out.println("PAN structure is as follows: AAAPL1234C");
                        System.out.println("please enter the PAN number again");
                        p=1;
                    }

                }while(p==1);

                DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");        //Take the system date and time as the check in date and time
                Date dateobj = new Date();
                ob.checkin_date_time[i]=df.format(dateobj);

                int w=0;                                                      //Input for the type of suit the guest wishes to live in
                while(w==0)
                {
                    System.out.println("Enter 1 for Deluxe suit-- Rs.2000/day \n 2 for Super Deluxe suit-- Rs.4000/day \n 3 for Executive suit-- Rs.6000/day  \n 4 for Presidential suite-- Rs.8000/day ");
                    String s1=sc.next();
                    s1+=sc.nextLine();
                    int s=0; 
                    try
                    { s=Integer.parseInt(s1);
                    }catch(Exception e)
                    {
                    }

                    switch(s)
                    {
                        case 1:
                        ob.suite[i]="Deluxe";
                        w=1;
                        break;
                        case 2:
                        ob.suite[i]="Super Deluxe";
                        w=1;
                        break;
                        case 3:
                        ob.suite[i]="Executive";
                        w=1;
                        break;
                        case 4:
                        ob.suite[i]="Presidential";
                        w=1;
                        break;
                        default:
                        System.out.println("Wrong choice");
                    }
                }
            }
            System.out.println("");
            System.out.println("\t\t\t\t\t\t\t\tRegistration is complete!");
            System.out.println("\t\t\t\t\t\t\t\t*************************");
            System.out.println("");
        }
        else
        {
            System.out.println("Sorry ,we are out of rooms");                                          //inavailibity of rooms in the hotel
            System.out.println("We have only "+ob.remaining_rooms+" rooms at the moment");
        }
    }
}
