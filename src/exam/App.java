package exam;

import exam.container.Container;
import exam.controller.ArticleController;
import exam.controller.Controller;
import exam.controller.MemberController;

public class App {

	private MemberController memberController;
	private ArticleController articleController;

	public App() {
		memberController = new MemberController();
		articleController = new ArticleController();
	}

	public void run() {
		while (true) {
			System.out.printf("명령어) ");
			String cmd = Container.sc.nextLine();

			if (cmd.equals("exit")) {
				System.out.println("== 시스템종료 ==");
				break;
			}
			Controller controller = getControllerByCmd(cmd);
			controller.run(cmd);
		}
	}

	private Controller getControllerByCmd(String cmd) {
		if (cmd.startsWith("member ")) {
			memberController.run(cmd);
		} else if (cmd.startsWith("article ")) {
			articleController.run(cmd);
		}
		return null;
	}
}