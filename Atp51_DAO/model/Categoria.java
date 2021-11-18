package BancoDeDados.Atp51_DAO.model;

public class Categoria {
    private int id;
    private String nome;
    private String descricao;

    public Categoria(String nome, String descricao){
        this.nome = nome;
        this.descricao = descricao;
    }

    public Categoria(int id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public Categoria(String descricao, int id){
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        String retorno = String.format("\nId: %d || Nome: %s ", this.id, this.nome);
        System.out.println("\n===================================");
        return retorno;
    }
}
