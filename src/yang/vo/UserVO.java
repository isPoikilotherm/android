package yang.vo;

public class UserVO {
	  private int id;
	  private String name;
	  private String psw;
	  private String pet_name;
	  
	  //构造方法
	public UserVO() {
		super();
	}
	public UserVO(int id, String name, String psw, String pet_name) {
		super();
		this.id = id;
		this.name = name;
		this.psw = psw;
		this.pet_name = pet_name;
	}
	
	
	//get set 方法
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	public String getPet_name() {
		return pet_name;
	}
	public void setPet_name(String pet_name) {
		this.pet_name = pet_name;
	}
	
	//

}
