package ch.hilbri.assist.application.splashHandlers;

import org.eclipse.core.runtime.IProduct;
import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.splash.BasicSplashHandler;

/**
 * Custom Splash Screen
 * 
 *
 */
public class SplashHandler extends BasicSplashHandler {

	private final static int MESSAGE_X = 25;

	private final static int MESSAGE_Y = 250;

	private final static int MESSAGE_WIDTH = 300;

	private final static int MESSAGE_HEIGHT = 20;

	private final static int VERSION_X = 20;

	private final static int VERSION_Y = 20;

	private final static int VERSION_R = 255;
	private final static int VERSION_G = 255;
	private final static int VERSION_B = 255;

	public SplashHandler() {
		super();
	}

	@Override
	public void init(Shell splash) {
		super.init(splash);

		Rectangle progressRect = new Rectangle(MESSAGE_X, MESSAGE_Y, MESSAGE_WIDTH, MESSAGE_HEIGHT);
		setMessageRect(progressRect);

		IProduct product = Platform.getProduct();
		final String version = product.getProperty("version");

		if (version != null) {

			getContent().addPaintListener(new PaintListener() {

				public void paintControl(PaintEvent e) {
					String versionText = "Version: " + version + " (" + System.getProperty("os.name") + " " + System.getProperty("sun.arch.data.model") + "bit)";
					e.gc.setForeground(new Color(null, VERSION_R, VERSION_G, VERSION_B));
					e.gc.drawText(versionText, VERSION_X, VERSION_Y, true);
				}
			});

		}
	}
}
