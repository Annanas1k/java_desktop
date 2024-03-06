package javav.mvc.view;

import javav.mvc.controller.GestiuneBDController;
import javav.mvc.controller.TranzactiiController;
import javav.mvc.model.GestiuneBDModel;
import javav.mvc.model.TranzactiiModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class StartPage extends JFrame {

    Color color1 = new Color(0x2D3250);
    Color color2 = new Color(0x424769);
    Color color3 = new Color(0x7077A1);
    Color color4 = new Color(0xF6B17A);

    Font menuFont = new Font("Serif", Font.BOLD, 20);
    Font labelFont = new Font("Serif", Font.BOLD, 20);


    public StartPage() {
        setTitle("Exchanger");
        setSize(1100, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel leftPanel = new JPanel(new GridBagLayout());
        leftPanel.setBackground(color1);
        leftPanel.setPreferredSize(new Dimension(200, getHeight()));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.weighty = 1;

        JLabel menuLabel = new JLabel("MENU");
        JLabel not = new JLabel(". ");
        menuLabel.setForeground(Color.white);
        menuLabel.setFont(labelFont);
        leftPanel.add(menuLabel);
        leftPanel.add(not);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(color1);
        JMenu tranzactiiMenu = new JMenu("Tranzacții");
        JMenu cursuriMenu = new JMenu("Cursuri de schimb");
        JMenu rapoarteMenu = new JMenu("Rapoarte");
        JMenu statisticaMenu = new JMenu("Statistică");
        JMenu administrareMenu = new JMenu("Administrare");

        tranzactiiMenu.setForeground(Color.white); tranzactiiMenu.setFont(menuFont);
        cursuriMenu.setForeground(Color.white); cursuriMenu.setFont(menuFont);
        rapoarteMenu.setForeground(Color.white); rapoarteMenu.setFont(menuFont);
        statisticaMenu.setForeground(Color.white); statisticaMenu.setFont(menuFont);
        administrareMenu.setForeground(Color.white); administrareMenu.setFont(menuFont);

        JMenuItem tr1 = new JMenuItem("1)Înregistrare nouă tranzacție");
        JMenuItem tr2 = new JMenuItem("3)Excludere tranzacții până la o anumită dată");
        JMenuItem tr3 = new JMenuItem("8)Afișare tranzacții la o anumită dată");
        JMenuItem tr4 = new JMenuItem("9)Afișare tranzacții la zi");
        JMenuItem cu1 = new JMenuItem("2)Actualizare cursuri de schimb valutar");
        JMenuItem ra1 = new JMenuItem("4)Afișare curs la zi");
        JMenuItem ra2 = new JMenuItem("4)Export date în fișier MS Word");
        JMenuItem ra3 = new JMenuItem("4)Export date în fișier MS Excel");
        JMenuItem st1 = new JMenuItem("5)Determinare comision total");
        JMenuItem st2 = new JMenuItem("6)Determinare valută străină cea mai solicitată");
        JMenuItem st3 = new JMenuItem("7)Determinare data celei mai avantajoase tranzacții");
        JMenuItem ad1 = new JMenuItem("10)Excludere tranzacții realizate în ultima lună");
        JMenuItem ad2 = new JMenuItem("Gestiune Curs Valutar");
        JMenuItem ad3 = new JMenuItem("Gestiune Tranzactii");



        tranzactiiMenu.add(tr1); tranzactiiMenu.add(tr2); tranzactiiMenu.add(tr3); tranzactiiMenu.add(tr4);
        cursuriMenu.add(cu1);
        rapoarteMenu.add(ra1); rapoarteMenu.add(ra2); rapoarteMenu.add(ra3);
        statisticaMenu.add(st1); statisticaMenu.add(st2); statisticaMenu.add(st3);
        administrareMenu.add(ad1); administrareMenu.add(ad2); administrareMenu.add(ad3);

        menuBar.add(tranzactiiMenu);
        menuBar.add(cursuriMenu);
        menuBar.add(rapoarteMenu);
        menuBar.add(statisticaMenu);
        menuBar.add(administrareMenu);

        menuBar.setLayout(new BoxLayout(menuBar, BoxLayout.Y_AXIS));
        gbc.gridy = 1;
        leftPanel.add(menuBar, gbc);

        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.lightGray);

        setLayout(new BorderLayout());
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);

        setVisible(true);


        tr1.addActionListener(e -> {
            NewTransactionFrame newTransactionFrame = new NewTransactionFrame();
            rightPanel.removeAll();
            rightPanel.add(newTransactionFrame);
            rightPanel.revalidate();
            rightPanel.repaint();
        });
        tr2.addActionListener(e -> {
            DelleteTransaction delleteTransaction = new DelleteTransaction();
            rightPanel.removeAll();
            rightPanel.add(delleteTransaction);
            rightPanel.revalidate();
            rightPanel.repaint();
        });
        tr3.addActionListener(e -> {
            SelectTransactionPerDate selectTransactionPerDate = new SelectTransactionPerDate();
            rightPanel.removeAll();
            rightPanel.add(selectTransactionPerDate);
            rightPanel.revalidate();
            rightPanel.repaint();
        });
        tr4.addActionListener(e -> {
            SelectTransaction selectTransaction = new SelectTransaction();
            rightPanel.removeAll();
            rightPanel.add(selectTransaction);
            rightPanel.revalidate();
            rightPanel.repaint();
        });
        cu1.addActionListener(e -> {
            UpdateCurs updateCurs = new UpdateCurs();
            rightPanel.removeAll();
            rightPanel.add(updateCurs);
            rightPanel.revalidate();
            rightPanel.repaint();
        });
        ra1.addActionListener(e -> {
            SelectCurs selectCurs = new SelectCurs();
            rightPanel.removeAll();
            rightPanel.add(selectCurs);
            rightPanel.revalidate();
            rightPanel.repaint();
        });
        st1.addActionListener(e -> {
            TotalComision  totalComision = new TotalComision();
            rightPanel.removeAll();
            rightPanel.add(totalComision);
            rightPanel.revalidate();
            rightPanel.repaint();
        });
        st2.addActionListener(e -> {
            ValutaStrainaSolicitata valutaStrainaSolicitata = new ValutaStrainaSolicitata();
            rightPanel.removeAll();
            rightPanel.add(valutaStrainaSolicitata);
            rightPanel.revalidate();
            rightPanel.repaint();
        });
        st3.addActionListener(e -> {
            ValutaCeaAvanatajoasa valutaCeaAvanatajoasa = new ValutaCeaAvanatajoasa();
            rightPanel.removeAll();
            rightPanel.add(valutaCeaAvanatajoasa);
            rightPanel.revalidate();
            rightPanel.repaint();
        });
        ad1.addActionListener(e -> {
            DelleteTransactionPerMounth delleteTransactionPerMounth = new DelleteTransactionPerMounth();
            rightPanel.removeAll();
            rightPanel.add(delleteTransactionPerMounth);
            rightPanel.revalidate();
            rightPanel.repaint();
        });
        ad2.addActionListener(e -> {
            GestiuneBDModel model = new GestiuneBDModel();
            GestiuneBDView gestiuneBDView = new GestiuneBDView(model);
            GestiuneBDController controller = new GestiuneBDController(model, gestiuneBDView);
            rightPanel.removeAll();
            rightPanel.add(gestiuneBDView);
            rightPanel.revalidate();
            rightPanel.repaint();
        });
        ad3.addActionListener(e -> {
            TranzactiiModel model = new TranzactiiModel();
            TranzactiiView tranzactiiView = new TranzactiiView(model);
            TranzactiiController controller = new TranzactiiController(tranzactiiView, model);
            rightPanel.removeAll();
            rightPanel.add(tranzactiiView);
            rightPanel.revalidate();
            rightPanel.repaint();
        });




    }


}
