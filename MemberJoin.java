import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
public class MemberJoin {
 
    Scanner sc = new Scanner(System.in);
    List<Member> members = new ArrayList<>();
    
    public MemberJoin() {
    }
 
    public void run() {
        
        int key = 0;
        while ((key = menu()) != 0) {
            switch (key) {
                case 1:
                    Login();
                    break;
                case 2:
                    MemberJoin();
                    break;
                case 3:
                   System.exit(-1);
            }
        }
    }
 
    private void MemberJoin() {
        sc.nextLine();
       
        String email = getStrInput("Email : ");
        String pw = getStrInput("PassWord : ");
        String pw2 = getStrInput("Password Confirm : ");
        String name = getStrInput("Name : ");
        String phone =getStrInput("Phone:");
      
        
        if(idCheck(email)) {
            System.out.println("�ߺ��� email�Դϴ�.");
        }else if(pw.equals(pw2)) {
            members.add(new Member(email, pw, name, phone));
            System.out.println("������ ���ϵ帳�ϴ�.");
        }else {
            System.out.println("��й�ȣ�� Ȯ�����ּ���.");
        }
        
    }
 
    private boolean idCheck(String email) {
        boolean check = true;
        Member member = FindById(email);
        if(member == null)
            check = false;
        return check;
    }
 
    private void Login() {
        sc.nextLine();
        String email = getStrInput("      Email : ");
        String pw = getStrInput("PassWord : ");
        
        Member member = FindById(email);
        if(member == null){
            System.out.println("��ϵ��� ���� ID�Դϴ�.");
        }else if(member.getPassword().equals(pw)) {
            System.out.println( "�α��� �ϼ̽��ϴ�.");
        }else {
            System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
        }
    }
 
    private Member FindById(String id) {
        for(Member memberDTO : members) {
            if(memberDTO.getEmail().equals(id)) {
                return memberDTO;
            }
        }
        return null;
    }
 
    private String getStrInput(String msg) {
        System.out.println(msg);
        return sc.nextLine();        
    }
 
    private int menu() {
        System.out.println("�䰡�� ���迡 ���Ű��� ȯ���մϴ�.");
        return getNumInput("[1]�α��� [2]ȸ������ [3]����");
    }
 
    private int getNumInput(String msg) {
        System.out.println(msg);
        return sc.nextInt();
    }
 
}

 