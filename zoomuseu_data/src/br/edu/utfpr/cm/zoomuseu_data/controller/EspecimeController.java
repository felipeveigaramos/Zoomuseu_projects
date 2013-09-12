	package br.edu.utfpr.cm.zoomuseu_data.controller;

import java.util.ArrayList;

import java.util.List;

import br.edu.utfpr.cm.zoomuseu_data.bean.EspecimeBean;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.Report;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.ValidationException;
import br.edu.utfpr.cm.zoomuseu_data.controller.validation.Validator;
import br.edu.utfpr.cm.zoomuseu_data.model.InterfaceEspecimeModel;
import br.edu.utfpr.cm.zoomuseu_data.model.ModelFactory;



public class EspecimeController implements InterfaceEspecimeController {
private InterfaceEspecimeModel iem;

public EspecimeController() {
iem = ModelFactory.getInstance().getInterfaceEspecimeModel();
}

@Override
public long inserir(EspecimeBean eb) throws ValidationException {
long id = -1;
if (eValido(eb)) {
id = iem.inserir(eb);
}
return id;

}

@Override
public void remover(long id) {
iem.remover(id);

}

@Override
public void atualizar(EspecimeBean eb) throws ValidationException {
if (eValido(eb)) {
iem.atualizar(eb);
}
}

@Override
public EspecimeBean pesquisar(long id) {
return iem.pesquisar(id);

}

@Override
public List<EspecimeBean> pesquisar() {
return iem.pesquisar();

}

private boolean eValido(EspecimeBean eb) throws ValidationException {
boolean valido = true;
List<Report> erros = new ArrayList<Report>();

if (!eb.getClassificacao().eValida()) {
erros.add(new Report("classificação",
"deve ser preenchida ao menos até ordem"));
throw new ValidationException("Classificação inválida", erros);
}

try {
valido = Validator.validar(eb.getLocalizacao(), false);
valido = valido && Validator.validar(eb, false);
} catch (ValidationException ve) {
if (erros != null && erros.size() > 0) {
ve.addErros(erros);
}
throw ve;
} catch (Exception e) {
e.printStackTrace();
}

return valido;
}

@Override
public List<EspecimeBean> pesquisar(String nomesPopulares, boolean identico) {
return iem.pesquisar(nomesPopulares, identico);
}

@Override
public List<EspecimeBean> pesquisarEspecie(String nomeEspecie, boolean identico) {
	return iem.pesquisarEspecie(nomeEspecie, identico);
}

}
