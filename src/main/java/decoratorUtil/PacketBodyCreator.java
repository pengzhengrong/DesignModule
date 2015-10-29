package decoratorUtil;

/**
 * 装饰者模式：角色  ： 组件接口，具体组件，装饰者，被装饰者
 * 这是被装饰者，主要是核心数据，没有经过任何的处理加工
 * @author pzr
 *
 */
public class PacketBodyCreator implements IPacketCreator {

	public String handle() {
		// TODO Auto-generated method stub
		//核心数据，不包括任何的格式
		return "&nbsp;我的名字叫什么？</p>";
	}

}
