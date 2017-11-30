import java.util.LinkedList;
import java.util.TreeSet;

public class MailServer extends LinkedList<Message> {

	TreeSet<Actor> registeredUsers;
	
	MailServer(){
		registeredUsers = new TreeSet<Actor>();
	}
	
	public void signUp(Actor a) {
		if (!registeredUsers.contains(a))
			registeredUsers.add(a);
	}
	
	public void dispatch(Message m) {
		if(m.getRecipient() == null) {
			for(Actor a : registeredUsers) {
				a.receive(m);
			}
		}else {
			Actor a = m.getRecipient();
			a.receive(m);
		}
	}
	
}
