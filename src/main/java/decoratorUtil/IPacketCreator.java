package decoratorUtil;


/**
 * 装饰者模式：角色  ： 组件接口，具体组件，装饰者，被装饰者
 * 这是一个接口，组件接口。是装饰者和被装饰者的超类。它定义了被装饰者的核心功能和装饰者需要加强的功能点。
 * @author pzr
 *
 */
public interface IPacketCreator {

	//处理内容
	public String handle();
	
}
