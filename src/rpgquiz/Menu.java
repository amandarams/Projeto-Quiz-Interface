package rpgquiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Menu extends JFrame {

    public Menu() {
        setTitle("Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(195, 205, 230));
        setPreferredSize(new Dimension(600, 450));

        JPanel painelBotoes = new JPanel();
        painelBotoes.setBackground(new Color(195, 205, 230));
        painelBotoes.setLayout(new BoxLayout(painelBotoes, BoxLayout.Y_AXIS));

        JButton botaoJogar = criarBotao("Jogar");
        JButton botaoInstrucoes = criarBotao("Instruções");
        JButton botaoCreditos = criarBotao("Créditos");
        JButton botaoSair = criarBotao("Sair");

        painelBotoes.add(Box.createVerticalGlue());
        painelBotoes.add(botaoJogar);
        painelBotoes.add(Box.createVerticalStrut(10));
        painelBotoes.add(botaoInstrucoes);
        painelBotoes.add(Box.createVerticalStrut(10));
        painelBotoes.add(botaoCreditos);
        painelBotoes.add(Box.createVerticalStrut(10));
        painelBotoes.add(botaoSair);
        painelBotoes.add(Box.createVerticalGlue());

        add(painelBotoes, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JButton criarBotao(String texto) {
        JButton botao = new JButton(texto);
        botao.setPreferredSize(new Dimension(200, 50));
        botao.setBackground(new Color(160, 168, 217));
        botao.setForeground(Color.WHITE);
        botao.setFont(botao.getFont().deriveFont(Font.BOLD, 16f));
        botao.setFocusPainted(false);
        botao.setAlignmentX(Component.CENTER_ALIGNMENT);
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (texto.equals("Sair")) {
                    dispose(); // Fecha a janela
                } else if (texto.equals("Instruções")) {
                    exibirInstrucoes(); // Mostra as instruções
                } else if (texto.equals("Créditos")) {
                    exibirCreditos(); // Mostra os créditos
                } else if (texto.equals("Jogar")) {
                    if (e.getActionCommand().equals("Jogar")) {
                        String nome = JOptionPane.showInputDialog(Menu.this, "Digite seu nome:");
                        JOptionPane.showMessageDialog(Menu.this, "Seja bem-vindo(a), " + nome + "!");
                        exibirSelecaoNivel(); // Mostra a seleção de nível
                    }
                } else {
                    System.out.println("Botão " + texto + " pressionado.");
                }
            }

        });
        return botao;
    }

    private void exibirInstrucoes() {
        String mensagem = "INSTRUÇÕES\n\n"
                + "AO CLICAR EM \"JOGAR\", VOCÊ TERÁ TRÊS OPÇÕES:\n"
                + "NÍVEL FÁCIL, NÍVEL MÉDIO E NÍVEL DIFÍCIL.\n\n"
                + "APÓS CLICAR EM UMA DAS TRÊS OPÇÕES, VOCÊ TERÁ DEZ PERGUNTAS\n"
                + "PARA RESPONDER E UM NÚMERO DE TENTATIVAS.\n\n"
                + "- NÍVEL FÁCIL TERÁ 4 TENTATIVAS.\n\n"
                + "- NÍVEL MÉDIO TERÁ 3 TENTATIVAS.\n\n"
                + "- NÍVEL DIFÍCIL TERÁ 2 TENTATIVAS.\n\n"
                + "AO FINAL DO JOGO OU APÓS ATINGIR O LIMITE DE TENTATIVAS,\n"
                + "APARECERÁ O PLACAR\n"
                + "APARECERÁ A PONTUAÇÃO TOTAL DO JOGADOR.\n\n"
                + "REGRA NÚMERO 1 = NÃO VALE COLAR DA INTERNET.\n"
                + "REGRA NÚMERO 2 = NÃO VALE COLAR DO COLEGUINHA.";

        JOptionPane.showMessageDialog(this, mensagem, "Instruções", JOptionPane.INFORMATION_MESSAGE);
    }

    private void exibirCreditos() {
        String mensagem = "CRÉDITOS\n\n"
                + "NATHANAEL\n"
                + "AMANDA\n"
                + "KAREN\n"
                + "VINICIUS";

        JOptionPane.showMessageDialog(this, mensagem, "Créditos", JOptionPane.INFORMATION_MESSAGE);
    }

    private void exibirSelecaoNivel() {
        JFrame frameNivel = new JFrame();
        frameNivel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameNivel.getContentPane().setBackground(new Color(195, 205, 230));
        frameNivel.setPreferredSize(new Dimension(600, 450));

        JPanel painelNivel = new JPanel();
        painelNivel.setBackground(new Color(195, 205, 230));
        painelNivel.setLayout(new BorderLayout());

        JLabel tituloLabel = new JLabel("Escolha um nível para jogar:");
        tituloLabel.setFont(tituloLabel.getFont().deriveFont(Font.BOLD, 20f));
        tituloLabel.setForeground(Color.WHITE); // Define a cor do texto para branco
        tituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
        painelNivel.add(tituloLabel, BorderLayout.NORTH);

        JPanel painelBotoes = new JPanel();
        painelBotoes.setBackground(new Color(195, 205, 230));
        painelBotoes.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Centraliza os componentes

        JButton botaoNivelFacil = criarBotao("Nível Fácil");

        botaoNivelFacil.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                class NivelFacil extends JFrame implements ActionListener {

                    private JLabel questionLabel;
                    private java.util.List<JRadioButton> optionButtons;
                    private java.util.List<Integer> shuffledIndices;

                    private String[] questoes = {
                        "Qual país foi o campeão da Copa do Mundo de 2022?",
                        "Qual é o nome da empresa de tecnologia que criou o iPhone?",
                        "Em qual data é comemorada a Independência do Brasil?",
                        "Qual foi o navegador português que chegou ao Brasil em 1500?",
                        "Qual é o nome da primeira mulher a se tornar presidente do Brasil?",
                        "A qual país europeu a Rússia declarou guerra em 2022?",
                        "Qual é a capital da Argentina?",
                        "Qual é o idioma oficial da China?",
                        "Quem pintou o quadro chamado 'Mona Lisa'?",
                        "Quantos jogadores titulares tem um time de basquete?"
                    };

                    private String[][] alternativas = {
                        {"Alemanha", "França", "Brasil", "Argentina"},
                        {"Google", "Amazon", "Microsoft", "Apple"},
                        {"25 de dezembro", "12 de outubro", "15 de novembro", "7 de setembro"},
                        {"Vasco da Gama", "Pedro Álvares Cabral", "Cristóvão Colombo", "Fernão de Magalhães"},
                        {"Marina Silva", "Dilma Rousseff", "Marta Suplicy", "Ana Júlia Carepa"},
                        {"Itália", "Alemanha", "França", "Ucrânia"},
                        {"Assunção", "Buenos Aires", "Bogotá", "Brasília"},
                        {"Hindi", "Mandarim", "Urdu", "Telugo"},
                        {"Pablo Picasso", "Claude Monet", "Salvador Dalí", "Leonardo da Vinci"},
                        {"Cinco", "Seis", "Sete", "Nove"}
                    };

                    private String[] respostasCorretas = {
                        "Argentina", "Apple", "7 de setembro", "Pedro Álvares Cabral",
                        "Dilma Rousseff", "Ucrânia", "Buenos Aires", "Mandarim",
                        "Leonardo da Vinci", "Cinco"
                    };

                    private int perguntaAtual;
                    private int pontuacao;
                    private int tentativas;

                    public NivelFacil() {
                        setTitle("Quiz");
                        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        setResizable(false);
                        setSize(500, 400);
                        setLocationRelativeTo(null);

                        JPanel mainPanel = new JPanel();
                        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
                        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
                        getContentPane().add(mainPanel);

                        // Painel da pergunta
                        JPanel questionPanel = new JPanel();
                        questionPanel.setLayout(new BoxLayout(questionPanel, BoxLayout.Y_AXIS));
                        questionPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
                        mainPanel.add(questionPanel);

                        questionLabel = new JLabel();
                        questionLabel.setFont(new Font("Arial", Font.PLAIN, 14));
                        questionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
                        questionPanel.add(questionLabel);

                        optionButtons = new ArrayList<>();

                        for (int i = 0; i < 4; i++) {
                            JRadioButton optionButton = new JRadioButton();
                            optionButton.setFont(new Font("Arial", Font.PLAIN, 12));
                            optionButton.setAlignmentX(Component.LEFT_ALIGNMENT);
                            optionButton.addActionListener(this);
                            optionButtons.add(optionButton);
                            questionPanel.add(optionButton);
                        }

                        iniciarJogo();
                    }

                    private void iniciarJogo() {
                        perguntaAtual = 0;
                        pontuacao = 0;
                        tentativas = 4;
                        shuffledIndices = new ArrayList<>();

                        for (int i = 0; i < questoes.length; i++) {
                            shuffledIndices.add(i);
                        }

                        Collections.shuffle(shuffledIndices);

                        reexibirPergunta();
                    }

                    private void reexibirPergunta() {
                        int questionIndex = shuffledIndices.get(perguntaAtual);

                        questionLabel.setText(questoes[questionIndex]);

                        java.util.List<String> options = new ArrayList<>();
                        for (int i = 0; i < 4; i++) {
                            options.add(alternativas[questionIndex][i]);
                        }

                        Collections.shuffle(options);

                        for (int i = 0; i < 4; i++) {
                            JRadioButton optionButton = optionButtons.get(i);
                            optionButton.setText(options.get(i));
                            optionButton.setSelected(false);
                            optionButton.setEnabled(true);
                        }
                    }

                    private void processarResposta() {
                        JRadioButton selectedButton = null;

                        for (JRadioButton optionButton : optionButtons) {
                            if (optionButton.isSelected()) {
                                selectedButton = optionButton;
                                break;
                            }
                        }

                        if (selectedButton == null) {
                            JOptionPane.showMessageDialog(this, "Selecione uma alternativa!", "Erro", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        String selecionarResposta = selectedButton.getText();
                        int questionIndex = shuffledIndices.get(perguntaAtual);
                        String respostaCorreta = respostasCorretas[questionIndex];

                        if (selecionarResposta.equals(respostaCorreta)) {
                            pontuacao++;
                            JOptionPane.showMessageDialog(this, "Resposta correta!", "Acerto", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            tentativas--;
                            if (tentativas == 0) {
                                finalizarJogo("Você atingiu o limite de tentativas. Pontuação: " + pontuacao);
                                return;
                            }

                            JOptionPane.showMessageDialog(this, "Resposta incorreta. Tente novamente! Tentativas restantes: " + tentativas, "Erro", JOptionPane.ERROR_MESSAGE);
                            reexibirPergunta(); // Embaralha as alternativas novamente
                            return;
                        }

                        perguntaAtual++;

                        if (perguntaAtual == questoes.length) {
                            finalizarJogo("Fim do jogo. Pontuação final: " + pontuacao);
                        } else {
                            reexibirPergunta();
                        }
                    }

                    private void finalizarJogo(String message) {
                        int opcao = JOptionPane.showOptionDialog(
                                this,
                                message + "\nDeseja jogar novamente?",
                                "Fim do Jogo",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.INFORMATION_MESSAGE,
                                null,
                                new Object[]{"Sim", "Não"}, // Opções traduzidas para o português
                                null
                        );

                        if (opcao == JOptionPane.YES_OPTION) {
                            iniciarJogo();
                        } else {
                            System.exit(0);
                        }
                    }

                    public void actionPerformed(ActionEvent e) {
                        processarResposta();
                    }
                }

                NivelFacil nivelFacil = new NivelFacil();
                nivelFacil.setVisible(true);
            }
        });

        JButton botaoNivelMedio = criarBotao("Nível Médio");
        botaoNivelMedio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                class NivelMedio extends JFrame implements ActionListener {

                    private JLabel questionLabel;
                    private java.util.List<JRadioButton> optionButtons;
                    private java.util.List<Integer> shuffledIndices;

                    private String[] questoes = {
                        "A queda do muro de Berlim, em 1989, marcou o fim de qual conflito?",
                        "Qual país foi o pioneiro na Revolução Industrial?",
                        "Em qual continente aconteceu a pandemia da chamada Peste Negra?",
                        "Qual é a posição do LeBron James?",
                        "O Brasil é banhado por qual oceano?",
                        "Quantos anéis compõem o símbolo dos Jogos Olímpicos?",
                        "Qual é o esporte mais popular do Japão?",
                        "Qual dos países abaixo localizam-se em dois continentes?",
                        "Qual das alternativas tem dois nove, um sete, três e quatro?",
                        "Em que ano os filmes deixaram de ser mudos?"
                    };

                    private String[][] alternativas = {
                        {"Segunda Guerra Mundial", "Guerra do Vietnã", "Guerra Fria", "Guerra de Berlim"},
                        {"Brasil", "Portugal", "Grécia", "Inglaterra"},
                        {"América", "África", "Ásia", "Europa"},
                        {"Ala - armador", "Pivô", "Ala-pivô", "Ala"},
                        {"Atlântico", "Índico", "Pacífico", "Glacial Ártico"},
                        {"Três", "Cinco", "Seis", "Oito"},
                        {"Judô", "Sumô", "Taekwondo", "Sujô"},
                        {"Egito", "Paquistão", "China", "Escócia"},
                        {"997444", "999174", "291734", "292722"},
                        {"1898", "1897", "1927", "1977"},};

                    private String[] respostasCorretas = {
                        "Guerra Fria", "Inglaterra", "Europa", "Ala", "Atlântico", "Cinco", "Judô", "Egito", "291734", "1927"
                    };
                    private int perguntaAtual;
                    private int pontuacao;
                    private int tentativas;

                    public NivelMedio() {
                        setTitle("Quiz");
                        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        setResizable(false);
                        setSize(500, 400);
                        setLocationRelativeTo(null);

                        JPanel mainPanel = new JPanel();
                        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
                        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
                        getContentPane().add(mainPanel);

                        // Painel da pergunta
                        JPanel questionPanel = new JPanel();
                        questionPanel.setLayout(new BoxLayout(questionPanel, BoxLayout.Y_AXIS));
                        questionPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
                        mainPanel.add(questionPanel);

                        questionLabel = new JLabel();
                        questionLabel.setFont(new Font("Arial", Font.PLAIN, 14));
                        questionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
                        questionPanel.add(questionLabel);

                        optionButtons = new ArrayList<>();

                        for (int i = 0; i < 4; i++) {
                            JRadioButton optionButton = new JRadioButton();
                            optionButton.setFont(new Font("Arial", Font.PLAIN, 12));
                            optionButton.setAlignmentX(Component.LEFT_ALIGNMENT);
                            optionButton.addActionListener(this);
                            optionButtons.add(optionButton);
                            questionPanel.add(optionButton);
                        }

                        iniciarJogo();
                    }

                    private void iniciarJogo() {
                        perguntaAtual = 0;
                        pontuacao = 0;
                        tentativas = 3;
                        shuffledIndices = new ArrayList<>();

                        for (int i = 0; i < questoes.length; i++) {
                            shuffledIndices.add(i);
                        }

                        Collections.shuffle(shuffledIndices);

                        reexibirPergunta();
                    }

                    private void reexibirPergunta() {
                        int questionIndex = shuffledIndices.get(perguntaAtual);

                        questionLabel.setText(questoes[questionIndex]);

                        java.util.List<String> options = new ArrayList<>();
                        for (int i = 0; i < 4; i++) {
                            options.add(alternativas[questionIndex][i]);
                        }

                        Collections.shuffle(options);

                        for (int i = 0; i < 4; i++) {
                            JRadioButton optionButton = optionButtons.get(i);
                            optionButton.setText(options.get(i));
                            optionButton.setSelected(false);
                            optionButton.setEnabled(true);
                        }
                    }

                    private void processarResposta() {
                        JRadioButton selectedButton = null;

                        for (JRadioButton optionButton : optionButtons) {
                            if (optionButton.isSelected()) {
                                selectedButton = optionButton;
                                break;
                            }
                        }

                        if (selectedButton == null) {
                            JOptionPane.showMessageDialog(this, "Selecione uma alternativa!", "Erro", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        String selecionarResposta = selectedButton.getText();
                        int questionIndex = shuffledIndices.get(perguntaAtual);
                        String respostaCorreta = respostasCorretas[questionIndex];

                        if (selecionarResposta.equals(respostaCorreta)) {
                            pontuacao++;
                            JOptionPane.showMessageDialog(this, "Resposta correta!", "Acerto", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            tentativas--;

                            if (tentativas == 0) {
                                finalizarJogo("Você atingiu o limite de tentativas. Pontuação: " + pontuacao);
                                return;
                            }

                            JOptionPane.showMessageDialog(this, "Resposta incorreta. Tente novamente! Tentativas restantes: " + tentativas, "Erro", JOptionPane.ERROR_MESSAGE);
                            reexibirPergunta(); // Embaralha as alternativas novamente
                            return;
                        }

                        perguntaAtual++;

                        if (perguntaAtual == questoes.length) {
                            finalizarJogo("Fim do jogo. Pontuação final: " + pontuacao);
                        } else {
                            reexibirPergunta();
                        }
                    }

                    private void finalizarJogo(String message) {
                        int opcao = JOptionPane.showOptionDialog(
                                this,
                                message + "\nDeseja jogar novamente?",
                                "Fim do Jogo",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.INFORMATION_MESSAGE,
                                null,
                                new Object[]{"Sim", "Não"}, // Opções traduzidas para o português
                                null
                        );

                        if (opcao == JOptionPane.YES_OPTION) {
                            iniciarJogo();
                        } else {
                            System.exit(0);
                        }

                    }

                    public void actionPerformed(ActionEvent e) {
                        processarResposta();
                    }
                }

                NivelMedio nivelMedio = new NivelMedio();
                nivelMedio.setVisible(true);
            }
        });
        JButton botaoNivelDificil = criarBotao("Nível Difícil");
        botaoNivelDificil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                class NivelDificil extends JFrame implements ActionListener {

                    private JLabel questionLabel;
                    private java.util.List<JRadioButton> optionButtons;
                    private java.util.List<Integer> shuffledIndices;

                    private String[] questoes = {
                        "Quem foi a primeira mulher a viajar para o espaço?",
                        "Qual animal produz o som mais alto?",
                        "Quem foi o inventor da vacina?",
                        "Qual o lugar mais profundo dos oceanos?",
                        "Quantos pares de costelas um ser humano, normalmente, "
                        + "possui?",
                        "Qual o país mais novo do mundo?",
                        "Qual é o significado correto de CPI",
                        "Qual time ganhou mais Champions League na história?",
                        "Qual jogador é o maior campeão da história da NBA?",
                        "Qual é o metal mais caro do mundo?"
                    };

                    private String[][] alternativas = {
                        {"Sally Ride", "Valentina Tereshkova", "Kathryn D. Sullivan", "Mae Jemison"},
                        {"Bugio", "Leão", "Baleia azul", "Hiena"},
                        {"Edward Jenner", "Louis Pasteur", " Albert Sabin", " Jonas Salk"},
                        {"Fossa de Bentley", "Fossa de Tonga", "Fossa de Java", "Fossa das Marianas"},
                        {"12", "5", "10", "8"},
                        {"Timor Leste", "Kosovo", "Montenegro", "Sudão do Sul"},
                        {"Câmara Parlamentar de Intervenção", "Congresso de Pediatria Internacional", "Coronavirus Pandemic Investigation", "Comissão Parlamentar de Inquérito"},
                        {"Real Madrid", "Barcelona", "Manchester United", "Milan"},
                        {"Michael Jordan", "Kobe Bryant", "LeBron James", "Bill Russell"},
                        {"Ouro", "Platina", "Ródio", "Paládio"}
                    };

                    private String[] respostaCorretas = {
                        "Valentina Tereshkova",
                        "Baleia azul",
                        "Edward Jenner",
                        "Fossa das Marianas",
                        "12",
                        "Sudão do Sul",
                        "Comissão Parlamentar de Inquérito",
                        "Real Madrid",
                        "Bill Russell",
                        "Ródio"
                    };

                    private int perguntaAtual;
                    private int pontuacao;
                    private int tentativas;

                    public NivelDificil() {
                        setTitle("Quiz");
                        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        setResizable(false);
                        setSize(500, 400);
                        setLocationRelativeTo(null);

                        JPanel mainPanel = new JPanel();
                        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
                        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
                        getContentPane().add(mainPanel);

                        // Painel da pergunta
                        JPanel questionPanel = new JPanel();
                        questionPanel.setLayout(new BoxLayout(questionPanel, BoxLayout.Y_AXIS));
                        questionPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
                        mainPanel.add(questionPanel);

                        questionLabel = new JLabel();
                        questionLabel.setFont(new Font("Arial", Font.PLAIN, 14));
                        questionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
                        questionPanel.add(questionLabel);

                        optionButtons = new ArrayList<>();

                        for (int i = 0; i < 4; i++) {
                            JRadioButton optionButton = new JRadioButton();
                            optionButton.setFont(new Font("Arial", Font.PLAIN, 12));
                            optionButton.setAlignmentX(Component.LEFT_ALIGNMENT);
                            optionButton.addActionListener(this);
                            optionButtons.add(optionButton);
                            questionPanel.add(optionButton);
                        }

                        iniciarJogo();
                    }

                    private void iniciarJogo() {
                        perguntaAtual = 0;
                        pontuacao = 0;
                        tentativas = 2;
                        shuffledIndices = new ArrayList<>();

                        for (int i = 0; i < questoes.length; i++) {
                            shuffledIndices.add(i);
                        }

                        Collections.shuffle(shuffledIndices);

                        reexibirPergunta();
                    }

                    private void reexibirPergunta() {
                        int questionIndex = shuffledIndices.get(perguntaAtual);

                        questionLabel.setText(questoes[questionIndex]);

                        java.util.List<String> options = new ArrayList<>();
                        for (int i = 0; i < 4; i++) {
                            options.add(alternativas[questionIndex][i]);
                        }

                        Collections.shuffle(options);

                        for (int i = 0; i < 4; i++) {
                            JRadioButton optionButton = optionButtons.get(i);
                            optionButton.setText(options.get(i));
                            optionButton.setSelected(false);
                            optionButton.setEnabled(true);
                        }
                    }

                    private void processarResposta() {
                        JRadioButton selectedButton = null;

                        for (JRadioButton optionButton : optionButtons) {
                            if (optionButton.isSelected()) {
                                selectedButton = optionButton;
                                break;
                            }
                        }

                        if (selectedButton == null) {
                            JOptionPane.showMessageDialog(this, "Selecione uma alternativa!", "Erro", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        String selecionarResposta = selectedButton.getText();
                        int questionIndex = shuffledIndices.get(perguntaAtual);
                        String respostaCorreta = respostaCorretas[questionIndex];

                        if (selecionarResposta.equals(respostaCorreta)) {
                            pontuacao++;
                            JOptionPane.showMessageDialog(this, "Resposta correta!", "Acerto", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            tentativas--;

                            if (tentativas == 0) {
                                finalizarJogo("Você atingiu o limite de tentativas. Pontuação: " + pontuacao);
                                return;
                            }

                            JOptionPane.showMessageDialog(this, "Resposta incorreta. Tente novamente! Tentativas restantes: " + tentativas, "Erro", JOptionPane.ERROR_MESSAGE);
                            reexibirPergunta(); // Embaralha as alternativas novamente
                            return;
                        }

                        perguntaAtual++;

                        if (perguntaAtual == questoes.length) {
                            finalizarJogo("Fim do jogo. Pontuação final: " + pontuacao);
                        } else {
                            reexibirPergunta();
                        }
                    }

                    private void finalizarJogo(String message) {
                        int opcao = JOptionPane.showOptionDialog(
                                this,
                                message + "\nDeseja jogar novamente?",
                                "Fim do Jogo",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.INFORMATION_MESSAGE,
                                null,
                                new Object[]{"Sim", "Não"}, // Opções traduzidas para o português
                                null
                        );

                        if (opcao == JOptionPane.YES_OPTION) {
                            iniciarJogo();
                        } else {
                            System.exit(0);
                        }
                    }

                    public void actionPerformed(ActionEvent e) {
                        processarResposta();
                    }
                }

                NivelDificil nivelDificil = new NivelDificil();
                nivelDificil.setVisible(true);
            }
        });

        painelBotoes.add(botaoNivelFacil);
        painelBotoes.add(botaoNivelMedio);
        painelBotoes.add(botaoNivelDificil);

        painelNivel.add(painelBotoes, BorderLayout.CENTER);

        frameNivel.add(painelNivel);
        frameNivel.pack();
        frameNivel.setLocationRelativeTo(null);
        frameNivel.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Menu();
            }
        });
    }
}
