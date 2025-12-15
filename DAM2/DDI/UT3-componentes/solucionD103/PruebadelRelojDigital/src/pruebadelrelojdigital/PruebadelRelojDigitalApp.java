

package pruebadelrelojdigital;

import java.awt.Window;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

public class PruebadelRelojDigitalApp extends SingleFrameApplication {

    @Override protected void startup() {
        show(new PruebadelRelojDigitalView(this));
    }

    @Override protected void configureWindow(Window root) {
    }

    public static PruebadelRelojDigitalApp getApplication() {
        return Application.getInstance(PruebadelRelojDigitalApp.class);
    }

    public static void main(String[] args) {
        launch(PruebadelRelojDigitalApp.class, args);
    }
}
