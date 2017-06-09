import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Calculadora extends JFrame {
    private Sobre sobre = new Sobre();
    private char operacao;
    private String copia;
    private double primeiro_numero;
    private double segundo_numero;
    private double resultado;
    private double rstd;
    private JButton jButton_0;
    private JButton jButton_1;
    private JButton jButton_2;
    private JButton jButton_3;
    private JButton jButton_4;
    private JButton jButton_5;
    private JButton jButton_6;
    private JButton jButton_7;
    private JButton jButton_8;
    private JButton jButton_9;
    private JButton jButton_Adicao;
    private JButton jButton_BSP;
    private JButton jButton_CE;
    private JButton jButton_CLR;
    private JButton jButton_Divisao;
    private JButton jButton_Igual;
    private JButton jButton_MaisOuMenos;
    private JButton jButton_Multiplicao;
    private JButton jButton_Ponto;
    private JButton jButton_Subtracao;
    private JMenuBar jMenuBar;
    private JMenu jMenu_Colar;
    private JMenu jMenu_Copiar;
    private JMenu jMenu_Sair;
    private JMenu jMenu_Sobre;
    private JPanel jPanel;
    private JTextField jTextField_Painel;

    public Calculadora() {
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
                new Calculadora().setVisible(true);
            }
        });
    }

    private void escolherOperacao(char op) throws NumberFormatException {
        double num_op = 0.0D;
        char oprc = '\000';
        boolean atv = false;
        if (getResultado() != 0.0D) {
            atv = true;
            setPrimeiro_numero(getResultado());
            setResultado(0.0D);
        } else if (getPrimeiro_numero() != 0.0D) {
            num_op = getPrimeiro_numero();
            oprc = getOperacao();
        }
        setOperacao(op);
        setPrimeiro_numero(Double.parseDouble(getjTextField_Painel().getText()));
        if ((num_op != 0.0D) && (atv != true)) {
            switch (oprc) {
                case '+':
                    setPrimeiro_numero(num_op + getPrimeiro_numero());
                    break;
                case '/':
                    setPrimeiro_numero(num_op / getPrimeiro_numero());
                    break;
                case '-':
                    setPrimeiro_numero(num_op - getPrimeiro_numero());
                    break;
                case '*':
                    setPrimeiro_numero(num_op * getPrimeiro_numero());
                case ',':
                case '.':
            }
            num_op = 0.0D;
        }
        getjTextField_Painel().setText("");
    }

    private void pegarNumeroDigitado(ActionEvent evt) {
        if (getResultado() != 0.0D) {
            String antes = getjTextField_Painel().getText();
            getjTextField_Painel().setText(((JButton) evt.getSource()).getText());
            if (".".equals(getjTextField_Painel().getText())) {
                getjTextField_Painel().setText(antes);
            } else {
                setResultado(0.0D);
                setPrimeiro_numero(0.0D);
            }
        } else {
            int total = getjTextField_Painel().getText().length();
            if (total < 16) {
                boolean Achou = false;
                for (int painel = getjTextField_Painel().getText().trim().length(); painel > 0; painel--) {
                    Character ponto = Character.valueOf(getjTextField_Painel().getText().trim().charAt(painel - 1));
                    if (".".equals(ponto.toString())) {
                        Achou = true;
                    }
                }
                if (!Achou)
                    getjTextField_Painel().setText(getjTextField_Painel().getText().trim() + ((JButton) evt.getSource()).getText());
                else if (Achou == true) {
                    if (".".equals(((JButton) evt.getSource()).getText()))
                        getjTextField_Painel().setText(getjTextField_Painel().getText().trim());
                    else {
                        getjTextField_Painel().setText(getjTextField_Painel().getText().trim() + ((JButton) evt.getSource()).getText());
                    }
                }
                if (".".equals(getjTextField_Painel().getText().trim())) getjTextField_Painel().setText("");
            }
        }
    }

    private void initComponents() {
        this.jPanel = new JPanel();
        this.jButton_Igual = new JButton();
        this.jButton_Adicao = new JButton();
        this.jButton_2 = new JButton();
        this.jButton_Divisao = new JButton();
        this.jButton_Multiplicao = new JButton();
        this.jButton_3 = new JButton();
        this.jButton_8 = new JButton();
        this.jButton_Subtracao = new JButton();
        this.jButton_Ponto = new JButton();
        this.jButton_6 = new JButton();
        this.jButton_0 = new JButton();
        this.jButton_CE = new JButton();
        this.jButton_7 = new JButton();
        this.jButton_CLR = new JButton();
        this.jButton_5 = new JButton();
        this.jButton_1 = new JButton();
        this.jButton_4 = new JButton();
        this.jButton_9 = new JButton();
        this.jTextField_Painel = new JTextField();
        this.jButton_BSP = new JButton();
        this.jButton_MaisOuMenos = new JButton();
        this.jMenuBar = new JMenuBar();
        this.jMenu_Copiar = new JMenu();
        this.jMenu_Colar = new JMenu();
        this.jMenu_Sobre = new JMenu();
        this.jMenu_Sair = new JMenu();
        setDefaultCloseOperation(3);
        setTitle("Calculadora");
        setResizable(false);
        this.jButton_Igual.setBackground(new Color(255, 255, 255));
        this.jButton_Igual.setFont(new Font("Times New Roman", 1, 24));
        this.jButton_Igual.setText("=");
        this.jButton_Igual.setToolTipText("Igualdade!");
        this.jButton_Igual.setCursor(new Cursor(0));
        this.jButton_Igual.setMargin(new Insets(0, 0, 0, 0));
        this.jButton_Igual.setMaximumSize(new Dimension(50, 50));
        this.jButton_Igual.setMinimumSize(new Dimension(50, 50));
        this.jButton_Igual.setPreferredSize(new Dimension(100, 50));
        this.jButton_Igual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calculadora.this.jButton_IgualActionPerformed(evt);
            }
        });
        this.jButton_Adicao.setBackground(new Color(255, 255, 255));
        this.jButton_Adicao.setFont(new Font("Times New Roman", 1, 24));
        this.jButton_Adicao.setText("+");
        this.jButton_Adicao.setToolTipText("Operação de adição!");
        this.jButton_Adicao.setCursor(new Cursor(0));
        this.jButton_Adicao.setMargin(new Insets(0, 0, 0, 0));
        this.jButton_Adicao.setMaximumSize(new Dimension(50, 50));
        this.jButton_Adicao.setMinimumSize(new Dimension(50, 50));
        this.jButton_Adicao.setPreferredSize(new Dimension(100, 50));
        this.jButton_Adicao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calculadora.this.jButton_AdicaoActionPerformed(evt);
            }
        });
        this.jButton_2.setBackground(new Color(255, 255, 255));
        this.jButton_2.setFont(new Font("Times New Roman", 1, 24));
        this.jButton_2.setText("2");
        this.jButton_2.setToolTipText("Numero 2!");
        this.jButton_2.setCursor(new Cursor(0));
        this.jButton_2.setMargin(new Insets(0, 0, 0, 0));
        this.jButton_2.setMaximumSize(new Dimension(50, 50));
        this.jButton_2.setMinimumSize(new Dimension(50, 50));
        this.jButton_2.setPreferredSize(new Dimension(100, 50));
        this.jButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calculadora.this.jButton_2ActionPerformed(evt);
            }
        });
        this.jButton_Divisao.setBackground(new Color(255, 255, 255));
        this.jButton_Divisao.setFont(new Font("Times New Roman", 1, 24));
        this.jButton_Divisao.setText("/");
        this.jButton_Divisao.setToolTipText("Operação de divisão!");
        this.jButton_Divisao.setCursor(new Cursor(0));
        this.jButton_Divisao.setMargin(new Insets(0, 0, 0, 0));
        this.jButton_Divisao.setMaximumSize(new Dimension(50, 50));
        this.jButton_Divisao.setMinimumSize(new Dimension(50, 50));
        this.jButton_Divisao.setPreferredSize(new Dimension(100, 50));
        this.jButton_Divisao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calculadora.this.jButton_DivisaoActionPerformed(evt);
            }
        });
        this.jButton_Multiplicao.setBackground(new Color(255, 255, 255));
        this.jButton_Multiplicao.setFont(new Font("Times New Roman", 1, 24));
        this.jButton_Multiplicao.setText("x");
        this.jButton_Multiplicao.setToolTipText("Operação de multiplicação!");
        this.jButton_Multiplicao.setCursor(new Cursor(0));
        this.jButton_Multiplicao.setMargin(new Insets(0, 0, 0, 0));
        this.jButton_Multiplicao.setMaximumSize(new Dimension(50, 50));
        this.jButton_Multiplicao.setMinimumSize(new Dimension(50, 50));
        this.jButton_Multiplicao.setPreferredSize(new Dimension(100, 50));
        this.jButton_Multiplicao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calculadora.this.jButton_MultiplicaoActionPerformed(evt);
            }
        });
        this.jButton_3.setBackground(new Color(255, 255, 255));
        this.jButton_3.setFont(new Font("Times New Roman", 1, 24));
        this.jButton_3.setText("3");
        this.jButton_3.setToolTipText("Numero 3!");
        this.jButton_3.setCursor(new Cursor(0));
        this.jButton_3.setMargin(new Insets(0, 0, 0, 0));
        this.jButton_3.setMaximumSize(new Dimension(50, 50));
        this.jButton_3.setMinimumSize(new Dimension(50, 50));
        this.jButton_3.setPreferredSize(new Dimension(100, 50));
        this.jButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calculadora.this.jButton_3ActionPerformed(evt);
            }
        });
        this.jButton_8.setBackground(new Color(255, 255, 255));
        this.jButton_8.setFont(new Font("Times New Roman", 1, 24));
        this.jButton_8.setText("8");
        this.jButton_8.setToolTipText("Numero 8!");
        this.jButton_8.setCursor(new Cursor(0));
        this.jButton_8.setMargin(new Insets(0, 0, 0, 0));
        this.jButton_8.setMaximumSize(new Dimension(50, 50));
        this.jButton_8.setMinimumSize(new Dimension(50, 50));
        this.jButton_8.setPreferredSize(new Dimension(100, 50));
        this.jButton_8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calculadora.this.jButton_8ActionPerformed(evt);
            }
        });
        this.jButton_Subtracao.setBackground(new Color(255, 255, 255));
        this.jButton_Subtracao.setFont(new Font("Times New Roman", 1, 24));
        this.jButton_Subtracao.setText("-");
        this.jButton_Subtracao.setToolTipText("Operação de subtração!");
        this.jButton_Subtracao.setCursor(new Cursor(0));
        this.jButton_Subtracao.setMargin(new Insets(0, 0, 0, 0));
        this.jButton_Subtracao.setMaximumSize(new Dimension(50, 50));
        this.jButton_Subtracao.setMinimumSize(new Dimension(50, 50));
        this.jButton_Subtracao.setPreferredSize(new Dimension(100, 50));
        this.jButton_Subtracao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calculadora.this.jButton_SubtracaoActionPerformed(evt);
            }
        });
        this.jButton_Ponto.setBackground(new Color(255, 255, 255));
        this.jButton_Ponto.setFont(new Font("Times New Roman", 1, 24));
        this.jButton_Ponto.setText(".");
        this.jButton_Ponto.setToolTipText("Ponto!");
        this.jButton_Ponto.setCursor(new Cursor(0));
        this.jButton_Ponto.setMargin(new Insets(0, 0, 0, 0));
        this.jButton_Ponto.setMaximumSize(new Dimension(50, 50));
        this.jButton_Ponto.setMinimumSize(new Dimension(50, 50));
        this.jButton_Ponto.setPreferredSize(new Dimension(100, 50));
        this.jButton_Ponto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calculadora.this.jButton_PontoActionPerformed(evt);
            }
        });
        this.jButton_6.setBackground(new Color(255, 255, 255));
        this.jButton_6.setFont(new Font("Times New Roman", 1, 24));
        this.jButton_6.setText("6");
        this.jButton_6.setToolTipText("Numero 6!");
        this.jButton_6.setCursor(new Cursor(0));
        this.jButton_6.setMargin(new Insets(0, 0, 0, 0));
        this.jButton_6.setMaximumSize(new Dimension(50, 50));
        this.jButton_6.setMinimumSize(new Dimension(50, 50));
        this.jButton_6.setPreferredSize(new Dimension(100, 50));
        this.jButton_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calculadora.this.jButton_6ActionPerformed(evt);
            }
        });
        this.jButton_0.setBackground(new Color(255, 255, 255));
        this.jButton_0.setFont(new Font("Times New Roman", 1, 24));
        this.jButton_0.setText("0");
        this.jButton_0.setToolTipText("Numero 0!");
        this.jButton_0.setCursor(new Cursor(0));
        this.jButton_0.setMargin(new Insets(0, 0, 0, 0));
        this.jButton_0.setMaximumSize(new Dimension(50, 50));
        this.jButton_0.setMinimumSize(new Dimension(50, 50));
        this.jButton_0.setPreferredSize(new Dimension(100, 50));
        this.jButton_0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calculadora.this.jButton_0ActionPerformed(evt);
            }
        });
        this.jButton_CE.setBackground(new Color(255, 255, 255));
        this.jButton_CE.setFont(new Font("Times New Roman", 1, 24));
        this.jButton_CE.setText("CE");
        this.jButton_CE.setToolTipText("Zera último numero!");
        this.jButton_CE.setCursor(new Cursor(0));
        this.jButton_CE.setMargin(new Insets(0, 0, 0, 0));
        this.jButton_CE.setMaximumSize(new Dimension(50, 50));
        this.jButton_CE.setMinimumSize(new Dimension(50, 50));
        this.jButton_CE.setPreferredSize(new Dimension(100, 50));
        this.jButton_CE.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calculadora.this.jButton_CEActionPerformed(evt);
            }
        });
        this.jButton_7.setBackground(new Color(255, 255, 255));
        this.jButton_7.setFont(new Font("Times New Roman", 1, 24));
        this.jButton_7.setText("7");
        this.jButton_7.setToolTipText("Numero 7!");
        this.jButton_7.setCursor(new Cursor(0));
        this.jButton_7.setMargin(new Insets(0, 0, 0, 0));
        this.jButton_7.setMaximumSize(new Dimension(50, 50));
        this.jButton_7.setMinimumSize(new Dimension(50, 50));
        this.jButton_7.setPreferredSize(new Dimension(100, 50));
        this.jButton_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calculadora.this.jButton_7ActionPerformed(evt);
            }
        });
        this.jButton_CLR.setBackground(new Color(255, 255, 255));
        this.jButton_CLR.setFont(new Font("Times New Roman", 1, 24));
        this.jButton_CLR.setText("CLR");
        this.jButton_CLR.setToolTipText("Limpa a tela!");
        this.jButton_CLR.setCursor(new Cursor(0));
        this.jButton_CLR.setMargin(new Insets(0, 0, 0, 0));
        this.jButton_CLR.setMaximumSize(new Dimension(50, 50));
        this.jButton_CLR.setMinimumSize(new Dimension(50, 50));
        this.jButton_CLR.setPreferredSize(new Dimension(100, 50));
        this.jButton_CLR.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calculadora.this.jButton_CLRActionPerformed(evt);
            }
        });
        this.jButton_5.setBackground(new Color(255, 255, 255));
        this.jButton_5.setFont(new Font("Times New Roman", 1, 24));
        this.jButton_5.setText("5");
        this.jButton_5.setToolTipText("Numero 5!");
        this.jButton_5.setCursor(new Cursor(0));
        this.jButton_5.setMargin(new Insets(0, 0, 0, 0));
        this.jButton_5.setMaximumSize(new Dimension(50, 50));
        this.jButton_5.setMinimumSize(new Dimension(50, 50));
        this.jButton_5.setPreferredSize(new Dimension(100, 50));
        this.jButton_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calculadora.this.jButton_5ActionPerformed(evt);
            }
        });
        this.jButton_1.setBackground(new Color(255, 255, 255));
        this.jButton_1.setFont(new Font("Times New Roman", 1, 24));
        this.jButton_1.setText("1");
        this.jButton_1.setToolTipText("Numero 1!");
        this.jButton_1.setCursor(new Cursor(0));
        this.jButton_1.setMargin(new Insets(0, 0, 0, 0));
        this.jButton_1.setMaximumSize(new Dimension(50, 50));
        this.jButton_1.setMinimumSize(new Dimension(50, 50));
        this.jButton_1.setPreferredSize(new Dimension(100, 50));
        this.jButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calculadora.this.jButton_1ActionPerformed(evt);
            }
        });
        this.jButton_4.setBackground(new Color(255, 255, 255));
        this.jButton_4.setFont(new Font("Times New Roman", 1, 24));
        this.jButton_4.setText("4");
        this.jButton_4.setToolTipText("Numero 4!");
        this.jButton_4.setCursor(new Cursor(0));
        this.jButton_4.setMargin(new Insets(0, 0, 0, 0));
        this.jButton_4.setMaximumSize(new Dimension(50, 50));
        this.jButton_4.setMinimumSize(new Dimension(50, 50));
        this.jButton_4.setPreferredSize(new Dimension(100, 50));
        this.jButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calculadora.this.jButton_4ActionPerformed(evt);
            }
        });
        this.jButton_9.setBackground(new Color(255, 255, 255));
        this.jButton_9.setFont(new Font("Times New Roman", 1, 24));
        this.jButton_9.setText("9");
        this.jButton_9.setToolTipText("Numero 9!");
        this.jButton_9.setCursor(new Cursor(0));
        this.jButton_9.setMargin(new Insets(0, 0, 0, 0));
        this.jButton_9.setMaximumSize(new Dimension(50, 50));
        this.jButton_9.setMinimumSize(new Dimension(50, 50));
        this.jButton_9.setPreferredSize(new Dimension(100, 50));
        this.jButton_9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calculadora.this.jButton_9ActionPerformed(evt);
            }
        });
        this.jTextField_Painel.setFont(new Font("Times New Roman", 1, 48));
        this.jTextField_Painel.setHorizontalAlignment(4);
        this.jTextField_Painel.setToolTipText("Painel");
        this.jTextField_Painel.setBorder(BorderFactory.createTitledBorder(null, "Hirohito's Calculos", 1, 1, new Font("Times New Roman", 0, 14)));
        this.jTextField_Painel.setCursor(new Cursor(0));
        this.jTextField_Painel.setEnabled(false);
        this.jTextField_Painel.setMargin(new Insets(0, 0, 0, 0));
        this.jTextField_Painel.setMaximumSize(new Dimension(50, 50));
        this.jTextField_Painel.setMinimumSize(new Dimension(50, 50));
        this.jTextField_Painel.setName("JPainel");
        this.jTextField_Painel.setPreferredSize(new Dimension(80, 80));
        this.jButton_BSP.setBackground(new Color(255, 255, 255));
        this.jButton_BSP.setFont(new Font("Times New Roman", 1, 24));
        this.jButton_BSP.setText("BSP");
        this.jButton_BSP.setToolTipText("Apaga o último caractere digitadado!");
        this.jButton_BSP.setCursor(new Cursor(0));
        this.jButton_BSP.setMargin(new Insets(0, 0, 0, 0));
        this.jButton_BSP.setMaximumSize(new Dimension(50, 50));
        this.jButton_BSP.setMinimumSize(new Dimension(50, 50));
        this.jButton_BSP.setPreferredSize(new Dimension(100, 50));
        this.jButton_BSP.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calculadora.this.jButton_BSPActionPerformed(evt);
            }
        });
        this.jButton_MaisOuMenos.setBackground(new Color(255, 255, 255));
        this.jButton_MaisOuMenos.setFont(new Font("Times New Roman", 1, 24));
        this.jButton_MaisOuMenos.setText("-/+");
        this.jButton_MaisOuMenos.setToolTipText("Troca de sinal!");
        this.jButton_MaisOuMenos.setCursor(new Cursor(0));
        this.jButton_MaisOuMenos.setMargin(new Insets(0, 0, 0, 0));
        this.jButton_MaisOuMenos.setMaximumSize(new Dimension(50, 50));
        this.jButton_MaisOuMenos.setMinimumSize(new Dimension(50, 50));
        this.jButton_MaisOuMenos.setPreferredSize(new Dimension(100, 50));
        this.jButton_MaisOuMenos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calculadora.this.jButton_MaisOuMenosActionPerformed(evt);
            }
        });
        GroupLayout jPanelLayout = new GroupLayout(this.jPanel);
        this.jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 446, 32767).addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelLayout.createSequentialGroup().addContainerGap().addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTextField_Painel, GroupLayout.Alignment.TRAILING, -1, 426, 32767).addGroup(jPanelLayout.createSequentialGroup().addComponent(this.jButton_BSP, -1, 102, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton_CE, -1, 102, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton_CLR, -1, 102, 32767).addGap(8, 8, 8).addComponent(this.jButton_MaisOuMenos, -2, 100, -2)).addGroup(jPanelLayout.createSequentialGroup().addComponent(this.jButton_7, -1, 102, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton_8, -1, 102, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton_9, -1, 102, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton_Divisao, -1, 102, 32767)).addGroup(jPanelLayout.createSequentialGroup().addComponent(this.jButton_0, -1, 102, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton_Ponto, -1, 102, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton_Igual, -1, 102, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton_Adicao, -1, 102, 32767)).addGroup(jPanelLayout.createSequentialGroup().addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, jPanelLayout.createSequentialGroup().addComponent(this.jButton_4, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton_5, -1, 104, 32767)).addGroup(jPanelLayout.createSequentialGroup().addComponent(this.jButton_1, -1, 102, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton_2, -1, 102, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jButton_3, -1, 102, 32767).addComponent(this.jButton_6, -2, 100, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jButton_Subtracao, -1, 102, 32767).addComponent(this.jButton_Multiplicao, -2, -1, -2)))).addContainerGap())));
        jPanelLayout.setVerticalGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 483, 32767).addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelLayout.createSequentialGroup().addContainerGap().addComponent(this.jTextField_Painel, -2, 126, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton_BSP, -1, -1, 32767).addComponent(this.jButton_CE, -1, -1, 32767).addComponent(this.jButton_CLR, -1, -1, 32767).addComponent(this.jButton_MaisOuMenos, -2, 60, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton_7, -1, 60, 32767).addComponent(this.jButton_8, -1, 60, 32767).addComponent(this.jButton_9, -1, 60, 32767).addComponent(this.jButton_Divisao, -1, 60, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton_5, -1, 60, 32767).addComponent(this.jButton_Multiplicao, -1, 60, 32767).addComponent(this.jButton_4, -1, 60, 32767).addComponent(this.jButton_6, -1, 60, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton_1, -1, 60, 32767).addComponent(this.jButton_2, -1, 60, 32767).addComponent(this.jButton_3, -1, 60, 32767).addComponent(this.jButton_Subtracao, -1, 60, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton_0, -1, 60, 32767).addComponent(this.jButton_Ponto, -1, 60, 32767).addComponent(this.jButton_Igual, -1, 60, 32767).addComponent(this.jButton_Adicao, -1, 60, 32767)).addContainerGap())));
        this.jMenuBar.setBorder(BorderFactory.createEtchedBorder());
        this.jMenuBar.setFont(new Font("Times New Roman", 0, 24));
        this.jMenuBar.setPreferredSize(new Dimension(80, 50));
        this.jMenu_Copiar.setBorder(BorderFactory.createBevelBorder(0));
        this.jMenu_Copiar.setMnemonic('e');
        this.jMenu_Copiar.setText("Copiar");
        this.jMenu_Copiar.setFont(new Font("Times New Roman", 0, 14));
        this.jMenu_Copiar.setPreferredSize(new Dimension(120, 40));
        this.jMenu_Copiar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                Calculadora.this.jMenu_CopiarMouseClicked(evt);
            }
        });
        this.jMenuBar.add(this.jMenu_Copiar);
        this.jMenu_Colar.setBorder(BorderFactory.createBevelBorder(0));
        this.jMenu_Colar.setMnemonic('e');
        this.jMenu_Colar.setText("Colar");
        this.jMenu_Colar.setFont(new Font("Times New Roman", 0, 14));
        this.jMenu_Colar.setPreferredSize(new Dimension(120, 40));
        this.jMenu_Colar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                Calculadora.this.jMenu_ColarMouseClicked(evt);
            }
        });
        this.jMenuBar.add(this.jMenu_Colar);
        this.jMenu_Sobre.setBorder(BorderFactory.createBevelBorder(0));
        this.jMenu_Sobre.setMnemonic('o');
        this.jMenu_Sobre.setText("Sobre");
        this.jMenu_Sobre.setToolTipText("Dados sobre o programa!");
        this.jMenu_Sobre.setFont(new Font("Times New Roman", 0, 14));
        this.jMenu_Sobre.setPreferredSize(new Dimension(120, 40));
        this.jMenu_Sobre.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                Calculadora.this.jMenu_SobreMouseClicked(evt);
            }
        });
        this.jMenuBar.add(this.jMenu_Sobre);
        this.jMenu_Sair.setBorder(BorderFactory.createBevelBorder(0));
        this.jMenu_Sair.setMnemonic('s');
        this.jMenu_Sair.setText("Sair");
        this.jMenu_Sair.setFont(new Font("Times New Roman", 0, 14));
        this.jMenu_Sair.setPreferredSize(new Dimension(95, 40));
        this.jMenu_Sair.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                Calculadora.this.jMenu_SairMouseClicked(evt);
            }
        });
        this.jMenuBar.add(this.jMenu_Sair);
        setJMenuBar(this.jMenuBar);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.jPanel, -2, -1, -2).addGap(0, 0, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.jPanel, -2, -1, -2).addGap(0, 0, 32767)));
        pack();
        setLocationRelativeTo(null);
    }

    private void jButton_IgualActionPerformed(ActionEvent evt) {
        setSegundo_numero(Double.parseDouble(getjTextField_Painel().getText()));
        switch (getOperacao()) {
            case '+':
                setResultado(getPrimeiro_numero() + getSegundo_numero());
                break;
            case '/':
                setResultado(getPrimeiro_numero() / getSegundo_numero());
                break;
            case '-':
                setResultado(getPrimeiro_numero() - getSegundo_numero());
                break;
            case '*':
                setResultado(getPrimeiro_numero() * getSegundo_numero());
            case ',':
            case '.':
        }
        getjTextField_Painel().setText(String.valueOf(getResultado()));
    }

    private void jButton_AdicaoActionPerformed(ActionEvent evt) {
        escolherOperacao('+');
    }

    private void jButton_2ActionPerformed(ActionEvent evt) {
        pegarNumeroDigitado(evt);
    }

    private void jButton_DivisaoActionPerformed(ActionEvent evt) {
        escolherOperacao('/');
    }

    private void jButton_MultiplicaoActionPerformed(ActionEvent evt) {
        escolherOperacao('*');
    }

    private void jButton_3ActionPerformed(ActionEvent evt) {
        pegarNumeroDigitado(evt);
    }

    private void jButton_8ActionPerformed(ActionEvent evt) {
        pegarNumeroDigitado(evt);
    }

    private void jButton_SubtracaoActionPerformed(ActionEvent evt) {
        escolherOperacao('-');
    }

    private void jButton_PontoActionPerformed(ActionEvent evt) {
        pegarNumeroDigitado(evt);
    }

    private void jButton_6ActionPerformed(ActionEvent evt) {
        pegarNumeroDigitado(evt);
    }

    private void jButton_0ActionPerformed(ActionEvent evt) {
        pegarNumeroDigitado(evt);
    }

    private void jButton_CEActionPerformed(ActionEvent evt) {
        if (!"".equals(this.jTextField_Painel.getText())) {
            setSegundo_numero(0.0D);
            getjTextField_Painel().setText(String.valueOf(getPrimeiro_numero()));
            if ("0.0".equals(getjTextField_Painel().getText())) getjTextField_Painel().setText("");
        }
    }

    private void jButton_7ActionPerformed(ActionEvent evt) {
        pegarNumeroDigitado(evt);
    }

    private void jButton_CLRActionPerformed(ActionEvent evt) {
        setPrimeiro_numero(0.0D);
        setSegundo_numero(0.0D);
        getjTextField_Painel().setText("");
    }

    private void jButton_5ActionPerformed(ActionEvent evt) {
        pegarNumeroDigitado(evt);
    }

    private void jButton_1ActionPerformed(ActionEvent evt) {
        pegarNumeroDigitado(evt);
    }

    private void jButton_4ActionPerformed(ActionEvent evt) {
        pegarNumeroDigitado(evt);
    }

    private void jButton_9ActionPerformed(ActionEvent evt) {
        pegarNumeroDigitado(evt);
    }

    private void jButton_BSPActionPerformed(ActionEvent evt) {
        if (!"".equals(getjTextField_Painel().getText().trim()))
            getjTextField_Painel().setText(getjTextField_Painel().getText().trim().substring(0, getjTextField_Painel().getText().trim().length() - 1));
    }

    private void jButton_MaisOuMenosActionPerformed(ActionEvent evt) {
        if (!"".equals(this.jTextField_Painel.getText())) {
            String temp = getjTextField_Painel().getText().trim();
            if (temp.startsWith("-")) temp = temp.substring(1, getjTextField_Painel().getText().length());
            else {
                temp = "-" + temp;
            }
            getjTextField_Painel().setText(temp);
        }
    }

    private void jMenu_CopiarMouseClicked(MouseEvent evt) {
        setCopia(getjTextField_Painel().getText());
    }

    private void jMenu_ColarMouseClicked(MouseEvent evt) {
        getjTextField_Painel().setText(getCopia());
    }

    private void jMenu_SobreMouseClicked(MouseEvent evt) {
        getSobre().show();
    }

    private void jMenu_SairMouseClicked(MouseEvent evt) {
        System.exit(0);
    }

    public Sobre getSobre() {
        return this.sobre;
    }

    public void setSobre(Sobre sobre) {
        this.sobre = sobre;
    }

    public char getOperacao() {
        return this.operacao;
    }

    public void setOperacao(char operacao) {
        this.operacao = operacao;
    }

    public String getCopia() {
        return this.copia;
    }

    public void setCopia(String copia) {
        this.copia = copia;
    }

    public double getPrimeiro_numero() {
        return this.primeiro_numero;
    }

    public void setPrimeiro_numero(double primeiro_numero) {
        this.primeiro_numero = primeiro_numero;
    }

    public double getSegundo_numero() {
        return this.segundo_numero;
    }

    public void setSegundo_numero(double segundo_numero) {
        this.segundo_numero = segundo_numero;
    }

    public double getResultado() {
        return this.resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public double getRstd() {
        return this.rstd;
    }

    public void setRstd(double rstd) {
        this.rstd = rstd;
    }

    public JButton getjButton_0() {
        return this.jButton_0;
    }

    public void setjButton_0(JButton jButton_0) {
        this.jButton_0 = jButton_0;
    }

    public JButton getjButton_1() {
        return this.jButton_1;
    }

    public void setjButton_1(JButton jButton_1) {
        this.jButton_1 = jButton_1;
    }

    public JButton getjButton_2() {
        return this.jButton_2;
    }

    public void setjButton_2(JButton jButton_2) {
        this.jButton_2 = jButton_2;
    }

    public JButton getjButton_3() {
        return this.jButton_3;
    }

    public void setjButton_3(JButton jButton_3) {
        this.jButton_3 = jButton_3;
    }

    public JButton getjButton_4() {
        return this.jButton_4;
    }

    public void setjButton_4(JButton jButton_4) {
        this.jButton_4 = jButton_4;
    }

    public JButton getjButton_5() {
        return this.jButton_5;
    }

    public void setjButton_5(JButton jButton_5) {
        this.jButton_5 = jButton_5;
    }

    public JButton getjButton_6() {
        return this.jButton_6;
    }

    public void setjButton_6(JButton jButton_6) {
        this.jButton_6 = jButton_6;
    }

    public JButton getjButton_7() {
        return this.jButton_7;
    }

    public void setjButton_7(JButton jButton_7) {
        this.jButton_7 = jButton_7;
    }

    public JButton getjButton_8() {
        return this.jButton_8;
    }

    public void setjButton_8(JButton jButton_8) {
        this.jButton_8 = jButton_8;
    }

    public JButton getjButton_9() {
        return this.jButton_9;
    }

    public void setjButton_9(JButton jButton_9) {
        this.jButton_9 = jButton_9;
    }

    public JButton getjButton_Adicao() {
        return this.jButton_Adicao;
    }

    public void setjButton_Adicao(JButton jButton_Adicao) {
        this.jButton_Adicao = jButton_Adicao;
    }

    public JButton getjButton_BSP() {
        return this.jButton_BSP;
    }

    public void setjButton_BSP(JButton jButton_BSP) {
        this.jButton_BSP = jButton_BSP;
    }

    public JButton getjButton_CE() {
        return this.jButton_CE;
    }

    public void setjButton_CE(JButton jButton_CE) {
        this.jButton_CE = jButton_CE;
    }

    public JButton getjButton_CLR() {
        return this.jButton_CLR;
    }

    public void setjButton_CLR(JButton jButton_CLR) {
        this.jButton_CLR = jButton_CLR;
    }

    public JButton getjButton_Divisao() {
        return this.jButton_Divisao;
    }

    public void setjButton_Divisao(JButton jButton_Divisao) {
        this.jButton_Divisao = jButton_Divisao;
    }

    public JButton getjButton_Igual() {
        return this.jButton_Igual;
    }

    public void setjButton_Igual(JButton jButton_Igual) {
        this.jButton_Igual = jButton_Igual;
    }

    public JButton getjButton_MaisOuMenos() {
        return this.jButton_MaisOuMenos;
    }

    public void setjButton_MaisOuMenos(JButton jButton_MaisOuMenos) {
        this.jButton_MaisOuMenos = jButton_MaisOuMenos;
    }

    public JButton getjButton_Multiplicao() {
        return this.jButton_Multiplicao;
    }

    public void setjButton_Multiplicao(JButton jButton_Multiplicao) {
        this.jButton_Multiplicao = jButton_Multiplicao;
    }

    public JButton getjButton_Ponto() {
        return this.jButton_Ponto;
    }

    public void setjButton_Ponto(JButton jButton_Ponto) {
        this.jButton_Ponto = jButton_Ponto;
    }

    public JButton getjButton_Subtracao() {
        return this.jButton_Subtracao;
    }

    public void setjButton_Subtracao(JButton jButton_Subtracao) {
        this.jButton_Subtracao = jButton_Subtracao;
    }

    public JMenuBar getjMenuBar() {
        return this.jMenuBar;
    }

    public void setjMenuBar(JMenuBar jMenuBar) {
        this.jMenuBar = jMenuBar;
    }

    public JMenu getjMenu_Colar() {
        return this.jMenu_Colar;
    }

    public void setjMenu_Colar(JMenu jMenu_Colar) {
        this.jMenu_Colar = jMenu_Colar;
    }

    public JMenu getjMenu_Copiar() {
        return this.jMenu_Copiar;
    }

    public void setjMenu_Copiar(JMenu jMenu_Copiar) {
        this.jMenu_Copiar = jMenu_Copiar;
    }

    public JMenu getjMenu_Sair() {
        return this.jMenu_Sair;
    }

    public void setjMenu_Sair(JMenu jMenu_Sair) {
        this.jMenu_Sair = jMenu_Sair;
    }

    public JMenu getjMenu_Sobre() {
        return this.jMenu_Sobre;
    }

    public void setjMenu_Sobre(JMenu jMenu_Sobre) {
        this.jMenu_Sobre = jMenu_Sobre;
    }

    public JPanel getjPanel() {
        return this.jPanel;
    }

    public void setjPanel(JPanel jPanel) {
        this.jPanel = jPanel;
    }

    public JTextField getjTextField_Painel() {
        return this.jTextField_Painel;
    }

    public void setjTextField_Painel(JTextField jTextField_Painel) {
        this.jTextField_Painel = jTextField_Painel;
    }
}