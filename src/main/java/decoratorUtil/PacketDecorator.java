package decoratorUtil;

/**
 * 装饰者模式：角色  ： 组件接口，具体组件，装饰者，被装饰者
 * 装饰者的抽象类。
 * @author pzr
 * 装饰者是一个抽象类。
 * 抽象类：把类的公共属性封装在抽象类中，然后子类可以扩展这些属性。
 */
public abstract class PacketDecorator implements IPacketCreator{

	IPacketCreator component;
	public PacketDecorator( IPacketCreator c){
		component = c;
	}
	
}
