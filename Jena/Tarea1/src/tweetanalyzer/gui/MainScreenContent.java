/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tweetanalyzer.gui;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.JRadioButton;
import org.apache.commons.lang3.StringUtils;
import sun.swing.StringUIClientPropertyKey;
import tweetanalyzer.TweetAnalyzer;
import tweetanalyzer.control.SaveSelectorEnum;
import tweetanalyzer.control.TweetSerializer;
import tweetanalyzer.control.TwitterConnector;
import tweetanalyzer.model.TweetObject;
import twitter4j.TwitterException;

/**
 *
 * @author D3str0y3r
 */
public class MainScreenContent extends javax.swing.JPanel {

    private List<TweetObject> result;
    private TwitterConnector tc;
    private TweetSerializer ts;
    
    /**
     * Creates new form MainWindow
     */
    public MainScreenContent() {
        initTwitterController();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        formatButtonGroup = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        searchLabel = new javax.swing.JLabel();
        searchText = new javax.swing.JTextField();
        classLabel = new javax.swing.JLabel();
        classText = new javax.swing.JTextField();
        tweetNoLabel = new javax.swing.JLabel();
        tweetSlider = new javax.swing.JSlider();
        tweetNoText = new javax.swing.JLabel();
        searchButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        turtleRadio = new javax.swing.JRadioButton();
        rdfRadio = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        resultConsole = new javax.swing.JScrollPane();
        consoleTextArea = new javax.swing.JTextArea();
        saveButton = new javax.swing.JButton();

        setNextFocusableComponent(searchButton);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));
        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        searchLabel.setLabelFor(searchText);
        searchLabel.setText("Search : ");

        searchText.setForeground(new java.awt.Color(153, 153, 153));
        searchText.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        searchText.setText("#Topic");
        searchText.setToolTipText("Search for a Tweet topic");
        searchText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchTextFocusLost(evt);
            }
        });
        searchText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchTextKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTextKeyReleased(evt);
            }
        });

        classLabel.setText("Class : ");

        classText.setForeground(new java.awt.Color(153, 153, 153));
        classText.setText("Introduce a class name");
        classText.setToolTipText("Introduce Tweet class name");
        classText.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        classText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                classTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                classTextFocusLost(evt);
            }
        });

        tweetNoLabel.setText("Tweet No. :");

        tweetSlider.setMajorTickSpacing(50);
        tweetSlider.setMaximum(200);
        tweetSlider.setMinorTickSpacing(10);
        tweetSlider.setPaintLabels(true);
        tweetSlider.setPaintTicks(true);
        tweetSlider.setValue(100);
        tweetSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tweetSliderStateChanged(evt);
            }
        });

        tweetNoText.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        tweetNoText.setText("100");

        searchButton.setText("Search");
        searchButton.setToolTipText("Find topic on Tweeter");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Format"));

        formatButtonGroup.add(turtleRadio);
        turtleRadio.setSelected(true);
        turtleRadio.setText("Turtle");
        turtleRadio.setToolTipText("");
        turtleRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                turtleRadioActionPerformed(evt);
            }
        });

        formatButtonGroup.add(rdfRadio);
        rdfRadio.setText("RDF/XML");
        rdfRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdfRadioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rdfRadio)
                .addGap(26, 26, 26))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(turtleRadio)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(turtleRadio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdfRadio)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(searchLabel)
                                    .addComponent(classLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(classText)
                                    .addComponent(searchText)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(tweetNoLabel)
                                .addGap(18, 18, 18)
                                .addComponent(tweetSlider, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                                .addGap(7, 7, 7)
                                .addComponent(tweetNoText)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchLabel)
                            .addComponent(searchText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(classLabel)
                            .addComponent(classText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tweetNoLabel)
                            .addComponent(tweetSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tweetNoText)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchButton)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Console"));

        resultConsole.setBackground(new java.awt.Color(0, 0, 0));
        resultConsole.setToolTipText("Result console");
        resultConsole.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        resultConsole.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        resultConsole.setEnabled(false);
        resultConsole.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N

        consoleTextArea.setEditable(false);
        consoleTextArea.setBackground(new java.awt.Color(51, 51, 51));
        consoleTextArea.setColumns(20);
        consoleTextArea.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        consoleTextArea.setForeground(new java.awt.Color(240, 240, 240));
        consoleTextArea.setLineWrap(true);
        consoleTextArea.setRows(5);
        consoleTextArea.setTabSize(4);
        consoleTextArea.setToolTipText("");
        resultConsole.setViewportView(consoleTextArea);

        saveButton.setText("Save");
        saveButton.setToolTipText("Save and serialize results");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(resultConsole)
                    .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(resultConsole, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tweetSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tweetSliderStateChanged
        if (tweetSlider.getValue() == 0) tweetSlider.setValue(1);
        String value = String.valueOf(tweetSlider.getValue());
        tweetNoText.setText(value);
        tweetSlider.setToolTipText(value);
    }//GEN-LAST:event_tweetSliderStateChanged

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        consoleTextArea.setText("");
        
        Enumeration elements = formatButtonGroup.getElements();
        while(elements.hasMoreElements()) {
            AbstractButton button = (AbstractButton) elements.nextElement();
            if (button.isSelected()) {
                try {
                    SaveSelectorEnum s = SaveSelectorEnum.getFromFormat(button.getText());
                    consoleTextArea.append("Saving models to "
                            + s.toString() + " format!\n");
                    ts.save(s);
                    consoleTextArea.append("Model correctly saved!\n");
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MainScreenContent.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void turtleRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_turtleRadioActionPerformed
        String consolePrev = consoleTextArea.getText() + "\n\n";
        consoleTextArea.setText(consolePrev + "Turtle serializer selected!");
    }//GEN-LAST:event_turtleRadioActionPerformed

    private void rdfRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdfRadioActionPerformed
        String consolePrev = consoleTextArea.getText() + "\n\n";
        consoleTextArea.setText(consolePrev + "XML/RDF serializer selected!");
    }//GEN-LAST:event_rdfRadioActionPerformed

    private void searchTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchTextFocusGained
        // TODO add your handling code here:
        if (searchText.getText().equalsIgnoreCase("#Topic")) searchText.setText("#");
    }//GEN-LAST:event_searchTextFocusGained

    private void searchTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchTextFocusLost
        // TODO add your handling code here:
        if (searchText.getText().equalsIgnoreCase("#")) searchText.setText("#Topic");
    }//GEN-LAST:event_searchTextFocusLost

    private void classTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_classTextFocusGained
        // TODO add your handling code here:
        if (classText.getText().equalsIgnoreCase("Introduce a class name")) {
            classText.setText("");
            classText.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_classTextFocusGained

    private void classTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_classTextFocusLost
        // TODO add your handling code here:
        if (classText.getText().equalsIgnoreCase("")) {
            classText.setText("Introduce a class name");
            classText.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_classTextFocusLost

    private void searchTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextKeyPressed
        if ("#".equals(searchText.getText())) evt.consume();
    }//GEN-LAST:event_searchTextKeyPressed

    private void searchTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextKeyReleased
        if(!"#".equals(searchText.getText())) searchText.setForeground(Color.BLACK);
        else searchText.setForeground(new Color(153, 153, 153));
    }//GEN-LAST:event_searchTextKeyReleased

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        try {
            consoleTextArea.setText("================= BEGIN ================\n");
            List<TweetObject> tempResult = tc.searchTweets(searchText.getText(), tweetSlider.getValue());
            for (TweetObject to : tempResult) {
                try {
                    printToConsole(to);
                    ts.feedModel(to, searchText.getText());
                } catch (NoSuchFieldException ex) {
                    Logger.getLogger(MainScreenContent.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchMethodException ex) {
                    Logger.getLogger(MainScreenContent.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(MainScreenContent.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(MainScreenContent.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex) {
                    Logger.getLogger(MainScreenContent.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            result.addAll(tempResult);
            consoleTextArea.append("================= END ================\n");
        } catch (TwitterException ex) {
            Logger.getLogger(TweetAnalyzer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel classLabel;
    private javax.swing.JTextField classText;
    private javax.swing.JTextArea consoleTextArea;
    private javax.swing.ButtonGroup formatButtonGroup;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton rdfRadio;
    private javax.swing.JScrollPane resultConsole;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel searchLabel;
    private javax.swing.JTextField searchText;
    private javax.swing.JRadioButton turtleRadio;
    private javax.swing.JLabel tweetNoLabel;
    private javax.swing.JLabel tweetNoText;
    private javax.swing.JSlider tweetSlider;
    // End of variables declaration//GEN-END:variables

    private void initTwitterController() {
        tc = new TwitterConnector();
        result = new ArrayList<>();
        ts = new TweetSerializer();
    }

    private void printToConsole(TweetObject s) 
            throws NoSuchFieldException, NoSuchMethodException, 
            IllegalAccessException, IllegalArgumentException, 
            InvocationTargetException {
        Field[] fieldz = TweetObject.class.getDeclaredFields();
        Method[] methodz = TweetObject.class.getMethods();
        
        for (Field f : fieldz) {
            String fName = f.getName();
            
            Method m = TweetObject.class.getMethod("get" + StringUtils.capitalize(fName), null);
            Object val = m.invoke(s, null);
            
            consoleTextArea.append(f.getName() + " : " + val.toString() + "\n");
        }
        
        consoleTextArea.append("\n\n");
        
        /*consoleTextArea.append(clazz.getField("id").toString() + " : " + s.getId() + "\n");
        consoleTextArea.append(clazz.getField("createdAt").toString() + " : " + s.getCreatedAt() + "\n");
        consoleTextArea.append(clazz.getField("replyTo").toString() + " : " + s.getReplyTo() + "\n");
        consoleTextArea.append(clazz.getField("text").toString() + " : " + s.getText() + "\n");
        consoleTextArea.append(clazz.getField("user").toString() + " : " + s.getUser() + "\n");
        consoleTextArea.append(clazz.getField("location").toString() + " : " + s.getLocation() + "\n");
        consoleTextArea.append(clazz.getField("langId").toString() + " : " + s.getLangId() + "\n");
        consoleTextArea.append(clazz.getField("topic").toString() + " : " + s.getTopic() + "\n");*/
    }
}
