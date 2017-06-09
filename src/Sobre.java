import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sobre extends JFrame {
    private JLabel j_Label_Curso;
    private JLabel j_Label_Faculdade;
    private JLabel j_Label_NetBeans;
    private JLabel j_Label_Nome;
    private JLabel j_Label_Periodo;
    private JLabel j_Label_SistemaOperacional;
    private JLabel j_Label_VersaoData;
    private JLabel j_Label_VersaoTexto;
    private JPanel j_Panel_Programador;
    private JPanel j_Panel_Sistema;

    public Sobre() {
        initComponents();
    }

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
        } catch (Exception e) {
            Logger.getLogger(Calculadora.class.getName()).log(Level.SEVERE, null, e);
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sobre().setVisible(true);
            }
        });
    }

    private void initComponents() {
        this.j_Panel_Programador = new JPanel();
        this.j_Label_Nome = new JLabel();
        this.j_Label_Faculdade = new JLabel();
        this.j_Label_Curso = new JLabel();
        this.j_Label_Periodo = new JLabel();
        this.j_Panel_Sistema = new JPanel();
        this.j_Label_SistemaOperacional = new JLabel();
        this.j_Label_NetBeans = new JLabel();
        this.j_Label_VersaoTexto = new JLabel();
        this.j_Label_VersaoData = new JLabel();
        setTitle("Sobre Calculator");
        setBackground(new Color(255, 255, 255));
        setLocationByPlatform(true);
        setName("Sobre");
        setResizable(false);
        this.j_Panel_Programador.setBorder(BorderFactory.createTitledBorder(null, "Programador", 0, 0, new Font("Times New Roman", 1, 14)));
        this.j_Panel_Programador.setFont(new Font("Times New Roman", 0, 14));
        this.j_Label_Nome.setFont(new Font("Times New Roman", 0, 14));
        this.j_Label_Nome.setText("Hirohito Pereira Gonçalves");
        this.j_Label_Nome.setBorder(BorderFactory.createEtchedBorder());
        this.j_Label_Nome.setMaximumSize(new Dimension(50, 50));
        this.j_Label_Nome.setMinimumSize(new Dimension(50, 50));
        this.j_Label_Nome.setPreferredSize(new Dimension(50, 50));
        this.j_Label_Faculdade.setFont(new Font("Times New Roman", 0, 14));
        this.j_Label_Faculdade.setText("FACTO");
        this.j_Label_Faculdade.setBorder(BorderFactory.createEtchedBorder());
        this.j_Label_Faculdade.setMaximumSize(new Dimension(50, 50));
        this.j_Label_Faculdade.setMinimumSize(new Dimension(50, 50));
        this.j_Label_Faculdade.setPreferredSize(new Dimension(50, 50));
        this.j_Label_Curso.setFont(new Font("Times New Roman", 0, 14));
        this.j_Label_Curso.setText("Sistemas de Informação");
        this.j_Label_Curso.setBorder(BorderFactory.createEtchedBorder());
        this.j_Label_Curso.setMaximumSize(new Dimension(50, 50));
        this.j_Label_Curso.setMinimumSize(new Dimension(50, 50));
        this.j_Label_Curso.setPreferredSize(new Dimension(50, 50));
        this.j_Label_Periodo.setFont(new Font("Times New Roman", 0, 14));
        this.j_Label_Periodo.setText("3º Período");
        this.j_Label_Periodo.setBorder(BorderFactory.createEtchedBorder());
        this.j_Label_Periodo.setMaximumSize(new Dimension(50, 50));
        this.j_Label_Periodo.setMinimumSize(new Dimension(50, 50));
        this.j_Label_Periodo.setPreferredSize(new Dimension(50, 50));
        GroupLayout j_Panel_ProgramadorLayout = new GroupLayout(this.j_Panel_Programador);
        this.j_Panel_Programador.setLayout(j_Panel_ProgramadorLayout);
        j_Panel_ProgramadorLayout.setHorizontalGroup(j_Panel_ProgramadorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, j_Panel_ProgramadorLayout.createSequentialGroup().addContainerGap().addGroup(j_Panel_ProgramadorLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.j_Label_Curso, GroupLayout.Alignment.LEADING, -1, 162, 32767).addComponent(this.j_Label_Faculdade, GroupLayout.Alignment.LEADING, -1, 162, 32767).addComponent(this.j_Label_Nome, GroupLayout.Alignment.LEADING, -1, 162, 32767).addComponent(this.j_Label_Periodo, GroupLayout.Alignment.LEADING, -1, 162, 32767)).addContainerGap()));
        j_Panel_ProgramadorLayout.setVerticalGroup(j_Panel_ProgramadorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(j_Panel_ProgramadorLayout.createSequentialGroup().addComponent(this.j_Label_Nome, -2, 30, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.j_Label_Faculdade, -2, 30, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.j_Label_Curso, -2, 30, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.j_Label_Periodo, -2, 30, -2)));
        this.j_Panel_Sistema.setBorder(BorderFactory.createTitledBorder(null, "Sistema", 0, 0, new Font("Times New Roman", 1, 14)));
        this.j_Label_SistemaOperacional.setFont(new Font("Times New Roman", 0, 14));
        this.j_Label_SistemaOperacional.setText("Windows 7");
        this.j_Label_SistemaOperacional.setBorder(BorderFactory.createEtchedBorder());
        this.j_Label_SistemaOperacional.setMaximumSize(new Dimension(50, 50));
        this.j_Label_SistemaOperacional.setMinimumSize(new Dimension(50, 50));
        this.j_Label_SistemaOperacional.setPreferredSize(new Dimension(50, 50));
        this.j_Label_NetBeans.setFont(new Font("Times New Roman", 0, 14));
        this.j_Label_NetBeans.setText("NetBeans IDE 7.0.1");
        this.j_Label_NetBeans.setBorder(BorderFactory.createEtchedBorder());
        this.j_Label_NetBeans.setMaximumSize(new Dimension(50, 50));
        this.j_Label_NetBeans.setMinimumSize(new Dimension(50, 50));
        this.j_Label_NetBeans.setPreferredSize(new Dimension(50, 50));
        this.j_Label_VersaoTexto.setFont(new Font("Times New Roman", 0, 14));
        this.j_Label_VersaoTexto.setText("Ultima versão em :");
        this.j_Label_VersaoTexto.setBorder(BorderFactory.createEtchedBorder());
        this.j_Label_VersaoTexto.setMaximumSize(new Dimension(50, 50));
        this.j_Label_VersaoTexto.setMinimumSize(new Dimension(50, 50));
        this.j_Label_VersaoTexto.setPreferredSize(new Dimension(50, 50));
        this.j_Label_VersaoData.setFont(new Font("Times New Roman", 0, 14));
        this.j_Label_VersaoData.setText("Quarta, 07 de março de 2012");
        this.j_Label_VersaoData.setBorder(BorderFactory.createEtchedBorder());
        this.j_Label_VersaoData.setMaximumSize(new Dimension(50, 50));
        this.j_Label_VersaoData.setMinimumSize(new Dimension(50, 50));
        this.j_Label_VersaoData.setPreferredSize(new Dimension(50, 50));
        GroupLayout j_Panel_SistemaLayout = new GroupLayout(this.j_Panel_Sistema);
        this.j_Panel_Sistema.setLayout(j_Panel_SistemaLayout);
        j_Panel_SistemaLayout.setHorizontalGroup(j_Panel_SistemaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.j_Label_VersaoData, -1, 197, 32767).addComponent(this.j_Label_VersaoTexto, -1, 197, 32767).addComponent(this.j_Label_NetBeans, -1, 197, 32767).addComponent(this.j_Label_SistemaOperacional, -1, 197, 32767));
        j_Panel_SistemaLayout.setVerticalGroup(j_Panel_SistemaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(j_Panel_SistemaLayout.createSequentialGroup().addComponent(this.j_Label_SistemaOperacional, -2, 30, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.j_Label_NetBeans, -2, 30, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.j_Label_VersaoTexto, -2, 30, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.j_Label_VersaoData, -2, 30, -2).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.j_Panel_Programador, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.j_Panel_Sistema, -2, -1, -2).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.j_Panel_Sistema, GroupLayout.Alignment.LEADING, 0, 167, 32767).addComponent(this.j_Panel_Programador, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap(-1, 32767)));
        pack();
        setLocationRelativeTo(null);
    }
}