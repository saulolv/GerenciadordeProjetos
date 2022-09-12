import java.util.Scanner;
import java.util.ArrayList;

public class Runner {
    ArrayList<Users> users = new ArrayList<Users>();
    ArrayList<Projetos> projetos = new ArrayList<Projetos>();
    ArrayList<Atividades> atividades = new ArrayList<Atividades>();

    public Runner() {
        this.run();
    }

    public void run() {
        openLogin();
    }

    public void openLogin() {
        System.out.println("\nBem vindo ao Gerenciador de Projetos!\n");
        
        Scanner in = new Scanner(System.in);

        int opc = 9;
        int count_users = 0;
        while(opc != 0) {
            System.out.println("Digite (1) para logar como usuario\n");
            System.out.println("Digite (2) para criar um usuario\n");
            System.out.println("Digite (3) se esqueceu a senha do usuario\n");
            System.out.println("Digite (0) para sair do programa");
            opc = in.nextInt();

            if(opc == 1) {
                System.out.println("Digite o id do usuario: ");
                int login = in.nextInt();

                for(int i = 0; i < users.size(); i++) {


                    if(users.get(i).getID() == login) {
                        System.out.printf("Digite a senha do usuario \"%d\": ", login);
                        String password = in.next();

                        if(users.get(i).getSenha().equals(password)) {
                            System.out.printf("LOGADO! Olá %s\n", users.get(i).getName());
                            menu();
                        }
                    }
                    else if(i == users.size()-1) {
                        System.out.println("Usuário não encontrado!\n");        
                    }

                }

            }
            else if(opc == 2) {
                System.out.println("Digite seu id: ");
                int id = in.nextInt();
                for(int i = 0; i < users.size(); i++) {
                    if(id == users.get(i).getID()) {
                        System.out.println("Esse ID já existe\nTente digitar outro ID: ");
                        id = in.nextInt();
                        i = 0;
                    }
                }
        
                Users newUser = new Users(id, "nome", "senha");
                newUser.addUsers(); 
                users.add(newUser);
                count_users++;
            }
            else if(opc == 3) {
                System.out.println("Digite seu id: ");
                int check_id = in.nextInt();
                
                for(int i = 0; i < users.size(); i++) {
                    if(check_id == users.get(i).getID()) {
                        System.out.println("Digite a nova senha do usuario: ");
                        Users newUser = new Users(users.get(i).getID(),users.get(i).getName(), users.get(i).getSenha());
                        newUser.editPassword();
                        users.set(i, newUser);
                    }
                }  
            }
            else if(opc == 0) {
                return;
            }
        }
    }

    public void menu() {
        System.out.println("Digite 1 para criar um projeto.");
        System.out.println("Digite 2 para remover um projeto.");
        System.out.println("Digite 3 para exibir relatório dos projetos.");
        System.out.println("Digite 4 para intercambiar um usuário para um projeto.");
        System.out.println("Digite 5 para atribuir um valor de bolsa a um usuário.");
        System.out.println("Digite 6 para editar um projeto a partir de um ID.");
        System.out.println("Digite 7 para associar um usuario a algum projeto.");
        System.out.println("Digite 8 para associar um projeto a um usuario.");
        System.out.println("Digite 9 para associar uma atividade a um usuário.");
        System.out.println("Digite 10 para associar um usuário a uma atividade.");
        System.out.println("Digite 11 para alterar o status de um projeto.");
        System.out.println("Digite 12 para consultar por usuário.");
        System.out.println("Digite 13 para consultar por ID de projeto.");
        System.out.println("Digite 14 para consultar por atividade.");
        System.out.println("Digite 15 para undo.");
        System.out.println("Digite 16 para redo.");
        System.out.println("Digite 0 para sair do programa.");

        mannager();
    }

    public void mannager() {
        Scanner in = new Scanner(System.in);
        int decide = in.nextInt();

        if(decide  == 1) {
            System.out.println("Digite a identificacao do seu novo projeto: ");
            String id = in.next();

            for(int i = 0; i < projetos.size(); i++) {
                if(id == projetos.get(i).getId()) {
                    System.out.println("Esse Identificacao pertence a outro projeto!\nTente digitar outra: ");
                    id = in.next();
                    i = 0;
                }
            }
            String[] pf = {"pf"};
            Projetos newProjeto = new Projetos(id, "desc", "1", "3", "41", "32", "coord", pf);
            newProjeto.addProjetos();
            projetos.add(newProjeto);
        }
        else if(decide == 2) {
            System.out.println("Digite a identificacao do projeto que deseja remover: ");
            String id = in.next();

            for(int i = 0; i < projetos.size(); i++) {
                if(projetos.get(i).getId().equals(id)) {
                    projetos.remove(i);
                    break;
                }
                else if(i == projetos.size()-1) {
                    System.out.println("Não existe projeto com essa identificação!\\nTente novamente: ");
                    id = in.next();
                    i = 0;
                }
            }
        }
        else if(decide == 3) {
            System.out.println("\nRELATORIO DE PROJETOS!\n\n");
            for (int i = 0; i < projetos.size(); i++) {
                System.out.println(projetos.get(i));
            }
        }
        else if(decide == 4) {
            
        }
        else if(decide == 5) {
            
        }
        else if (decide == 6) {
            System.out.println("Digite o ID do projeto que deseja editar: ");
            String id_edit_projeto = in.next();

            String edit;

            for (int j = 0; j < projetos.size(); j++) {
                if (projetos.get(j).getId().equalsIgnoreCase(id_edit_projeto)) {
                    boolean i = true;
                    while (i) {
                        i = false;

                        System.out.println("O que deseja editar: ");
                        edit = in.next();
                        if (edit.equalsIgnoreCase("identificacao")) {
                            System.out.println("Digite a nova identificacao do projeto: ");

                        } else if (edit.equalsIgnoreCase("descricao")) {
                            System.out.println("Digite a nova descricao do projeto: ");
                            projetos.get(j).desc();
                        } 
                        else if (edit.equalsIgnoreCase("data de inicio")) {
                            System.out.println("Digite a nova data de inicio do projeto: ");
                            projetos.get(j).dataI();
                        } 
                        else if (edit.equalsIgnoreCase("hora de inicio")) {
                            System.out.println("Digite a nova hora de inicio do projeto: ");
                            projetos.get(j).horaI();
                        } 
                        else if (edit.equalsIgnoreCase("data de termino")) {
                            System.out.println("Digite a nova data de termino do projeto: ");
                            projetos.get(j).dataT();
                        } 
                        else if (edit.equalsIgnoreCase("hora de termino")) {
                            System.out.println("Digite a nova hora de termino do projeto: ");
                            projetos.get(j).horaT();
                        } 
                        else if (edit.equalsIgnoreCase("coordenador")) {
                            System.out.println("Digite o novo coordenador do projeto: ");
                            projetos.get(j).coord();
                        } 
                        else if (edit.equalsIgnoreCase("profissionais")) {
                            System.out.println(
                                    "Digite 1 para adicionar um novo profissional, 2 para excluir um profissional e 3 para editar um profissional: ");
                            /*
                             * int editP = in.nextInt();
                             * if(editP == 1) {
                             * qntP++;
                             * System.out.println("Digite o nome do profissional: ");
                             * this.profissionais[qntP-1] = in.next();
                             * }
                             * else if(editP == 2) {
                             * System.out.println("Qual o nome do profissional que deseja remover: ");
                             * String name_removeP = in.next();
                             * for(int j = 0; j < qntP; j++) {
                             * if(name_removeP.equals(this.profissionais[j])) {
                             * this.profissionais[j] = null;
                             * qntP--;
                             * }
                             * }
                             * }
                             * else if(editP == 3) {
                             * System.out.println("Qual o nome do profissional que deseja editar: ");
                             * String name_editP = in.next();
                             * for(int j = 0; j < qntP; j++) {
                             * if(name_editP.equals(this.profissionais[j])) {
                             * System.out.println("Digite o novo nome do profissional: ");
                             * this.profissionais[j] = in.next();
                             * }
                             * }
                             * }
                             */
                        } else {
                            System.out.println("\nDigite uma opção válida!\n");
                            // i = true;
                        }
                    }
                }

            }

        }
        else if(decide == 7) {
            System.out.println("Digite o id do usuario que deseja associar: ");
            int user_asso = in.nextInt();

            for(int i = 0; i < users.size(); i++) {
                if(users.get(i).getID() == user_asso) {

                }
            }
            
        }
        else if(decide == 8) {
            
        }
        else if(decide == 9) {
            
        }
        else if(decide == 10) {
            
        }
        else if(decide == 11) {
            System.out.println("Digite o ID do projeto para alterar o status: ");
            String idProjeto = in.next();
            
            for(int i = 0; i < projetos.size(); i++) {
                if(idProjeto == projetos.get(i).getId()) {
                    projetos.get(i).statusProjeto();
                }
            }
        }
        else if(decide == 12) {
            System.out.println("Digite o ID do Usuario a ser consultado: ");
            int consultar_user = in.nextInt();

            for(int i = 0; i < users.size(); i++) {
                if(users.get(i).getID() == consultar_user) {
                    System.out.println(users.get(i));
                    break;
                }
                else if(users.size()-1 == i) {
                    System.out.println("Usuario não encotrado! ID errado!");
                }
            }
        }
        else if(decide == 13) {
            System.out.println("Digite o ID do projeto a ser consultado: ");
            String consultar_projeto = in.next();

            for(int i = 0; i < projetos.size(); i++) {
                if(projetos.get(i).getId().equalsIgnoreCase(consultar_projeto)) {
                    System.out.println(projetos.get(i));
                    break;
                }
                else if(projetos.size()-1 == i) {
                    System.out.println("Projeto não encotrado! ID errado!");
                }
            }
            
        }
        else if(decide == 14) {
            System.out.println("Digite o ID da atividade a ser consultada: ");
            String consultar_atividade = in.next();

            for(int i = 0; i < atividades.size(); i++) {
                if(atividades.get(i).getId().equalsIgnoreCase(consultar_atividade)) {
                    System.out.println(atividades.get(i));
                    break;
                }
                else if(projetos.size()-1 == i) {
                    System.out.println("Atividade não encotrada! ID errado!");
                }
            }
        }
        else if(decide == 15) {
            
        }
        else if(decide == 16) {
            
        }
        else if(decide == 17) {
            
        }
       
        
    }

}