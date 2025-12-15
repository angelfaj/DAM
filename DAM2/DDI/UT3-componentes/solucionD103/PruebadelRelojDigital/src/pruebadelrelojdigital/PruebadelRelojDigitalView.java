/*
 * PruebadelRelojDigitalView.java
 */

package pruebadelrelojdigital;

import org.jdesktop.application.Action;
import org.jdesktop.application.Application;
import org.jdesktop.application.ApplicationActionMap;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

import RelojDigital.RelojDigitalBean;
import RelojDigital.alarma;

public class PruebadelRelojDigitalView extends FrameView {

    private JPanel mainPanel;
    private JMenuBar menuBar;
    private JProgressBar progressBar;
    private RelojDigitalBean relojDigitalBean1;
    private JLabel statusAnimationLabel;
    private JLabel statusMessageLabel;
    private JPanel statusPanel;

    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;

    private JDialog aboutBox;

    public PruebadelRelojDigitalView(SingleFrameApplication app) {
        super(app);

        initComponents();

        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusMessageLabel.setText("");
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                statusAnimationLabel.setIcon(busyIcons[busyIconIndex]);
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
        statusAnimationLabel.setIcon(idleIcon);
        progressBar.setVisible(false);

        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                        statusAnimationLabel.setIcon(busyIcons[0]);
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(true);
                } else if ("done".equals(propertyName)) {
                    busyIconTimer.stop();
                    statusAnimationLabel.setIcon(idleIcon);
                    progressBar.setVisible(false);
                    progressBar.setValue(0);
                } else if ("message".equals(propertyName)) {
                    String text = (String)(evt.getNewValue());
                    statusMessageLabel.setText((text == null) ? "" : text);
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer)(evt.getNewValue());
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(false);
                    progressBar.setValue(value);
                }
            }
        });
    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = PruebadelRelojDigitalApp.getApplication().getMainFrame();
            aboutBox = new PruebadelRelojDigitalAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        PruebadelRelojDigitalApp.getApplication().show(aboutBox);
    }

    private void initComponents() {

        mainPanel = new JPanel();
        relojDigitalBean1 = new RelojDigitalBean();
        alarma al = new alarma(00, 02, "A mimir");
        al.setActiva(true);
        relojDigitalBean1.setMialarma(al);
        

        menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu();
        JMenuItem exitMenuItem = new JMenuItem();
        JMenu helpMenu = new JMenu();
        JMenuItem aboutMenuItem = new JMenuItem();
        statusPanel = new JPanel();
        JSeparator statusPanelSeparator = new JSeparator();
        statusMessageLabel = new JLabel();
        statusAnimationLabel = new JLabel();
        progressBar = new JProgressBar();

        mainPanel.setName("mainPanel"); 

        relojDigitalBean1.setName("relojDigitalBean1"); 
        relojDigitalBean1.addAlarmaListener(new RelojDigitalBean.AlarmaListener() {
            public void SuenaAlarma(RelojDigitalBean.AlarmaEvent evt) {
                relojDigitalBean1SuenaAlarma(evt);
            }
        });

        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(relojDigitalBean1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(193, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(relojDigitalBean1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(138, Short.MAX_VALUE))
        );

        menuBar.setName("menuBar"); 

        ResourceMap resourceMap = Application.getInstance(PruebadelRelojDigitalApp.class).getContext().getResourceMap(PruebadelRelojDigitalView.class);
        fileMenu.setText(resourceMap.getString("fileMenu.text")); 
        fileMenu.setName("fileMenu"); 

        ApplicationActionMap actionMap = Application.getInstance(PruebadelRelojDigitalApp.class).getContext().getActionMap(PruebadelRelojDigitalView.class, this);
        exitMenuItem.setAction(actionMap.get("quit")); 
        exitMenuItem.setName("exitMenuItem"); 
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); 
        helpMenu.setName("helpMenu"); 

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); 
        aboutMenuItem.setName("aboutMenuItem"); 
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        statusPanel.setName("statusPanel"); 

        statusPanelSeparator.setName("statusPanelSeparator"); 

        statusMessageLabel.setName("statusMessageLabel"); 

        statusAnimationLabel.setHorizontalAlignment(SwingConstants.LEFT);
        statusAnimationLabel.setName("statusAnimationLabel"); 

        progressBar.setName("progressBar"); 

        GroupLayout statusPanelLayout = new GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(statusPanelSeparator, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusMessageLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 216, Short.MAX_VALUE)
                .addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusAnimationLabel)
                .addContainerGap())
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(statusPanelSeparator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(statusPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(statusMessageLabel)
                    .addComponent(statusAnimationLabel)
                    .addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        setComponent(mainPanel);
        setMenuBar(menuBar);
        setStatusBar(statusPanel);
    }

    private void relojDigitalBean1SuenaAlarma(RelojDigitalBean.AlarmaEvent evt) {
        JOptionPane.showMessageDialog(null, evt.getMsg(), "Aviso",
        JOptionPane.INFORMATION_MESSAGE);
    }

}
