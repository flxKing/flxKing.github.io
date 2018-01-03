package first.zptc.cn.myapplication;
import java.util.Stack;

import android.widget.EditText;
import android.widget.Toast;

public class Cal {

    public Cal(EditText print,String str) {
        // TODO Auto-generated constructor stub
        char temp[]=new char[100];
        Stack<Character> optr=new Stack<Character>();
        Stack<Double> opnd=new Stack<Double>();
        int k=0,count=0;
        boolean flag=false;
        optr.clear();
        opnd.clear();
        optr.add('=');
        try{
            for(int i=0;i<str.length();){
                if(count++>1000)
                    flag=true;
                char ch=str.charAt(i);
                if(Character.isDigit(ch)||ch=='.'){
                    temp[k++]=ch;
                    i++;
                    continue;
                }
                if(k!=0){
                    opnd.add(Double.parseDouble(new String(temp,0,k)));
                    k=0;
                }
                switch(compare(optr.peek(),ch)){
                    case -1:flag=true;break;
                    case 60:optr.add(ch);i++;break;
                    case 61:optr.pop();i++;break;
                    case 62:opnd.add(result(opnd.pop(),opnd.pop(),optr.pop()));break;
                }
                if(flag){
                    break;
                }
            }
            if(flag)
                print.setText("请输入合法字符");
            else
                print.setText(opnd.pop().toString());
        }
        catch(Exception e){
            print.setText("请输入合法字符");
        }

    }

    private Double result(Double num1, Double num2, char ch) {
        // TODO Auto-generated method stub
        if(ch=='+')
            return num2+num1;
        if(ch=='-')
            return num2-num1;
        if(ch=='*')
            return num2*num1;
        if(ch=='/')
            return num2/num1;
        return num2;
    }

    private int compare(char ch1, char ch2) {
        // TODO Auto-generated method stub
        String oper[]={">><<<>>",">><<<>>",">>>><>>",
                ">>>><>>","<<<<<= ",">>>> >>","<<<<< ="};
        int x,y;
        x=to_num(ch1);
        y=to_num(ch2);
        if(x==-1||y==-1)
            return -1;
        return (int)(oper[x].charAt(y));
    }

    private int to_num(char ch) {
        // TODO Auto-generated method stub
        if(ch=='+')
            return 0;
        else if(ch=='-')
            return 1;
        else if(ch=='*')
            return 2;
        else if(ch=='/')
            return 3;
        else if(ch=='(')
            return 4;
        else if(ch==')')
            return 5;
        else if(ch=='=')
            return 6;
        else
            return -1;
    }

}