package br.ce.rafaelsilva.appium.core;

public class Mensagens {

    public enum MSG{
        SUCESSO_INSERIRCONTA{
            public String toString(){
                return "Conta adicionada com sucesso";
            }
        },

        SUCESSO_EXCLUIRCONTA{
            public String toString(){
                return "Conta excluída com sucesso";
            }
        },

        SUCESSO_EXCLUIRCMOVIMENTACAO{
            public String toString(){
                return "Movimentação removida com sucesso!";
            }
        },

        SUCESSO_MOVIMENTACAO{
            public String toString(){
                return "Movimentação cadastrada com sucesso";
            }
        },

        FALHA_INSERIRCONTA{
            public String toString(){
                return "Problemas de comunicação";
            }
        },

        FALHA_EXCLUIRCONTA_CONTA_EM_USO{
            public String toString(){
                return "Conta em uso nas movimentações";
            }
        },

        FALHA_MOVIMENTACAO_DATA{
            public String toString(){
                return "Data da Movimentação deve ser menor ou igual à data atual";
            }
        },
    }

}
