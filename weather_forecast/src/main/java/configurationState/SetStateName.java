package configurationState;

import java.util.HashMap;
import java.util.Map;

public class SetStateName {
    private Map<String, String> listName = new HashMap<>();

    public Map<String, String> getListName() {
        return listName;
    }

    public void setListName(Map<String, String> listName) {
        this.listName = listName;
    }

    private SetStateName(Map<String, String> listName) {
        this.listName = listName;
    }
    public static class SetStateNameBuilder{
        private Map<String, String> listName = new HashMap<>();
        public SetStateNameBuilder(){ }
        public SetStateNameBuilder listName(Map<String, String> listName){
            this.listName=listName;
            return this;
        }
        public SetStateName createSetStateName(){
            return new SetStateName(listName);
        }

    }

    public Map<String, String> getNameStates() {
        listName.put("AC", "Acre");
        listName.put("AL", "Alagoas");
        listName.put("AP", "Amapá");
        listName.put("AM", "Amazonas");
        listName.put("BA", "Bahia");
        listName.put("CE", "Ceará");
        listName.put("ES", "Espírito Santo");
        listName.put("GO", "Goiás");
        listName.put("MA", "Maranhão");
        listName.put("MT", "Mato Grosso");
        listName.put("MS", "Mato Grosso do Sul");
        listName.put("MG", "Minas Gerais");
        listName.put("PA", "Pará");
        listName.put("PB", "Paraíba");
        listName.put("PR", "Paraná");
        listName.put("PE", "Pernambuco");
        listName.put("PI", "Piauí");
        listName.put("RJ", "Rio de Janeiro");
        listName.put("RN", "Rio Grande do Norte");
        listName.put("RS", "Rio Grande do Sul");
        listName.put("RO", "Rondônia");
        listName.put("RR", "Roraima");
        listName.put("SC", "Santa Catarina");
        listName.put("SP", "São Paulo");
        listName.put("SE", "Sergipe");
        listName.put("TO", "Tocantins");
        listName.put("DF", "Distrito Federal");

        return listName;

    }
}
