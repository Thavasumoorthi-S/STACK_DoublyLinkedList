package org.example;
import java.util.*;
public class DoubleStack{
    Node Rootnode=null;
    Node temp=null;
    Node temp1=null;
    class Node{
        Node prevnode;
        int data;
        Node nextnode;

        Node(int data)
        {
            this.data=data;
        }
    }

    public void add(int data)
    {
        if(this.Rootnode==null)
        {
            this.Rootnode=new Node(data);
            this.Rootnode.prevnode=null;
            this.Rootnode.nextnode=null;

        }
        else{
            this.temp=new Node(data);
            temp.prevnode=null;
            temp.nextnode=this.Rootnode;
            this.Rootnode=this.temp;
        }
    }
    public void display()
    {
        Node temp2=this.Rootnode;
        if(temp2==null)
        {
            System.out.println("Empty node .....");
        }
        else {
            while (temp2.nextnode != null) {
                System.out.println(temp2.data);
                temp2 = temp2.nextnode;
            }
            System.out.println(temp2.data);
        }
    }
    public void Remove()
    {
        if(this.Rootnode==null)
        {
            System.out.println("Node is not present cannot delete node.......");
        }
        else {
            this.Rootnode = this.Rootnode.nextnode;
        }
    }
    public void insertatpos(int pos,int element)
    {
        int index=1;
        Node check=this.Rootnode;
        if(pos==0)
        {
            this.add(element);
        }
        else {
            while (index != pos) {
                check = check.nextnode;
                index++;
            }
            this.temp1 = new Node(element);
            this.temp1.nextnode = check.nextnode;
            check.nextnode = this.temp1;
        }
    }
    public void deleteatpos(int index)
    {
        int index1=1;
        if(index==0 && this.Rootnode==null)
        {
            System.out.println("Node is not present cannot delete given position .... ");
        }
        else if(index==0 && this.Rootnode.nextnode==null) {
            this.Rootnode=null;
        }
        else if(index==0 && this.Rootnode.nextnode!=null) {
            this.Rootnode = this.Rootnode.nextnode;
        }
        else {
            Node current=this.Rootnode;
            int c=0;
            while (index1 != index) {
              current=current.nextnode;
              index1++;
            }
            if(current.nextnode.nextnode==null)
            {
                current.nextnode=null;
            }
            else {
                current.nextnode=current.nextnode.nextnode;
            }
        }
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        DoubleStack dl=new DoubleStack();
        int choice;
        int element;
        int index;
        while(true)
        {
            System.out.println("\n1)Add element \n2)Remove Element \n3)display \n4)insert at position \n5)delete at position \n6)exit");
            System.out.println("Choose any one of the option in gthe above ");
            choice=sc.nextInt();
            if(choice==1)
            {
                System.out.println("Enter the element ");
                element=sc.nextInt();
                dl.add(element);

            }
            else if(choice==2)
            {
                dl.Remove();
            }
            else if(choice==3)
            {
                dl.display();
            }
            else if(choice==4)
            {
                System.out.println("Enter the index :");
                index=sc.nextInt();
                System.out.println("Enter the element :");
                element=sc.nextInt();
                dl.insertatpos(index,element);
            }
            else if(choice==5)
            {
                System.out.println("Enter the index :");
                index=sc.nextInt();
                dl.deleteatpos(index);
            }
            else if(choice==6)
            {
                break;
            }
        }

    }
}