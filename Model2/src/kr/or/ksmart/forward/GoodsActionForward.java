package kr.or.ksmart.forward;

public class GoodsActionForward {
	
	private boolean isRedirect = false;
	private String path = null;
	
	public boolean isRedirect() {
		return isRedirect;
	}
	
	public void setRedirect(boolean isRedirect) {
		System.out.println(isRedirect + "<--isRedirect setRedirect GoodsActionForward.java");
		this.isRedirect = isRedirect;
	}
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		System.out.println(path + "<--path setPath GoodsActionForward.java");
		this.path = path;
	}
}