/*
 * PruebadelRelojDigitalAboutBox.java
 */

package pruebadelrelojdigital;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import org.jdesktop.application.Action;
import org.jdesktop.application.Application;
import org.jdesktop.application.ApplicationActionMap;
import org.jdesktop.application.ResourceMap;

public class PruebadelRelojDigitalAboutBox extends javax.swing.JDialog {

    private JButton closeButton;
    
    public PruebadelRelojDigitalAboutBox(java.awt.Frame parent) {
        super(parent);
        initComponents();
        getRootPane().setDefaultButton(closeButton);
    }

    @Action public void closeAboutBox() {
        dispose();
    }

    private void initComponents() {

        closeButton = new JButton();
        JLabel appTitleLabel = new JLabel();
        JLabel versionLabel = new JLabel();
        JLabel appVersionLabel = new JLabel();
        JLabel vendorLabel = new JLabel();
        JLabel appVendorLabel = new JLabel();
        JLabel homepageLabel = new JLabel();
        JLabel appHomepageLabel = new JLabel();
        JLabel appDescLabel = new JLabel();
        JLabel imageLabel = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        ResourceMap resourceMap = Application.getInstance(pruebadelrelojdigital.PruebadelRelojDigitalApp.class).getContext().getResourceMap(PruebadelRelojDigitalAboutBox.class);
        setTitle(resourceMap.getString("title")); 
        setModal(true);
        setName("aboutBox"); 
        setResizable(false);

        ApplicationActionMap actionMap = Application.getInstance(pruebadelrelojdigital.PruebadelRelojDigitalApp.class).getContext().getActionMap(PruebadelRelojDigitalAboutBox.class, this);
        closeButton.setAction(actionMap.get("closeAboutBox")); 
        closeButton.setName("closeButton"); 

        appTitleLabel.setFont(appTitleLabel.getFont().deriveFont(appTitleLabel.getFont().getStyle() | Font.BOLD, appTitleLabel.getFont().getSize()+4));
        appTitleLabel.setText(resourceMap.getString("Application.title")); 
        appTitleLabel.setName("appTitleLabel"); 

        versionLabel.setFont(versionLabel.getFont().deriveFont(versionLabel.getFont().getStyle() | Font.BOLD));
        versionLabel.setText(resourceMap.getString("versionLabel.text")); 
        versionLabel.setName("versionLabel"); 

        appVersionLabel.setText(resourceMap.getString("Application.version")); 
        appVersionLabel.setName("appVersionLabel"); 

        vendorLabel.setFont(vendorLabel.getFont().deriveFont(vendorLabel.getFont().getStyle() | Font.BOLD));
        vendorLabel.setText(resourceMap.getString("vendorLabel.text")); 
        vendorLabel.setName("vendorLabel"); 

        appVendorLabel.setText(resourceMap.getString("Application.vendor")); 
        appVendorLabel.setName("appVendorLabel"); 

        homepageLabel.setFont(homepageLabel.getFont().deriveFont(homepageLabel.getFont().getStyle() | Font.BOLD));
        homepageLabel.setText(resourceMap.getString("homepageLabel.text")); 
        homepageLabel.setName("homepageLabel"); 

        appHomepageLabel.setText(resourceMap.getString("Application.homepage")); 
        appHomepageLabel.setName("appHomepageLabel"); 

        appDescLabel.setText(resourceMap.getString("appDescLabel.text")); 
        appDescLabel.setName("appDescLabel"); 

        imageLabel.setIcon(resourceMap.getIcon("imageLabel.icon")); 
        imageLabel.setName("imageLabel"); 

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(imageLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(versionLabel)
                            .addComponent(vendorLabel)
                            .addComponent(homepageLabel))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(appVersionLabel)
                            .addComponent(appVendorLabel)
                            .addComponent(appHomepageLabel)))
                    .addComponent(appTitleLabel, GroupLayout.Alignment.LEADING)
                    .addComponent(appDescLabel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                    .addComponent(closeButton))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(imageLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(appTitleLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(appDescLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(versionLabel)
                    .addComponent(appVersionLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(vendorLabel)
                    .addComponent(appVendorLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(homepageLabel)
                    .addComponent(appHomepageLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(closeButton)
                .addContainerGap())
        );

        pack();
    }
    
}
