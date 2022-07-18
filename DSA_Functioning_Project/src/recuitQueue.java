import java.io.*;
import java.util.*;
class recuitQueue
{
    static Scanner sc=new Scanner(System.in);
    class qname
    {
        qname next;
        String value;
        qname(String value)
        {
            this.value=value;
            next=null;
        }
    }
    static qname front,rear;
    static int c;
    void read() throws FileNotFoundException
    {
        Scanner cs=new Scanner(new File("/Users/bharath/Desktop/DSA_Project/recruit.txt"));
        while(cs.hasNextLine())
        {
            String line=cs.nextLine();
            StringTokenizer st=new StringTokenizer(line,",");
            c=st.countTokens();
            String n=st.nextToken();// getting the name from the cv
            enqueue(n);
        }
    }

    void enqueue(String key)

    {
        qname temp = new qname(key);
        if (this.rear == null) {
            this.front = this.rear = temp;
            return;
        }
        this.rear.next = temp;
        this.rear = temp;
    }

    void dequeue() throws IOException
    {
        if(this.front==null)
            return;
        qname temp=this.front;
        this.front=this.front.next;
        if(this.front==null)
            display();
    }

    void manager()throws IOException
    {
        qname temp=front;
        for(int i=1;i<c;i++)
        {
            System.out.println("Interview starts");
            temp = front;
            System.out.println(temp.value);
            System.out.println("1. select");
            System.out.println("2. reject");
            int ch=sc.nextInt();
            switch (ch)
            {
                case 1:
                    {
                        FileWriter fw=new FileWriter("/Users/bharath/Desktop/DSA_Project/finalList.txt",true);
                        BufferedWriter bw=new BufferedWriter(fw);
                        PrintWriter pw=new PrintWriter(bw);
                        pw.println(temp.value+" ");
                        System.out.println("Enter the email and password for the new employee");
                        String email=sc.next();
                        String password=sc.next();
                        pw.print(email+" ");
                        pw.print(password+" ");
                        pw.println();
                        pw.close();
                        bw.close();
                        fw.close();
                    }
                    break;
                case 2:
                    {
                        System.out.println("the candidate has been rejected");
                        break;
                    }
                default:
                    System.out.println("Invalid Entry");
            }
            dequeue();
        }
    }

    void display()throws IOException
    {
        System.out.println("The list of new employees:");
        readfinal();
    }

    void readfinal() throws FileNotFoundException
    {
        System.out.println("name");
        System.out.println("email     password");
        Scanner s=new Scanner(new File("/Users/bharath/Desktop/DSA_Project/finalList.txt"));
        while(s.hasNextLine())
        {
            String line = s.nextLine();
            System.out.println(line);
        }
        System.exit(0);
    }

    public void callRecuit() throws IOException
    {
        recuitQueue ob=new recuitQueue();
        ob.read();
        ob.manager();
        
    }
}