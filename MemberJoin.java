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
            System.out.println("중복된 email입니다.");
        }else if(pw.equals(pw2)) {
            members.add(new Member(email, pw, name, phone));
            System.out.println("가입을 축하드립니다.");
        }else {
            System.out.println("비밀번호를 확인해주세요.");
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
            System.out.println("등록되지 않은 ID입니다.");
        }else if(member.getPassword().equals(pw)) {
            System.out.println( "로그인 하셨습니다.");
        }else {
            System.out.println("비밀번호가 틀렸습니다.");
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
        System.out.println("요가에 세계에 오신것을 환영합니다.");
        return getNumInput("[1]로그인 [2]회원가입 [3]종료");
    }
 
    private int getNumInput(String msg) {
        System.out.println(msg);
        return sc.nextInt();
    }
 
}

 