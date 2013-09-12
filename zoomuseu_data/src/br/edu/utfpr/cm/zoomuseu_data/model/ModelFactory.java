package br.edu.utfpr.cm.zoomuseu_data.model;

public class ModelFactory {

	private static ModelFactory instance = null;

	private ModelFactory() {

	}

	public static ModelFactory getInstance() {
		if (ModelFactory.instance == null) {
			ModelFactory.instance = new ModelFactory();
		}
		return ModelFactory.instance;
	}

	public InterfaceFiloModel getInterfaceFiloModel() {
		return new FiloModel();
	}

	public InterfaceSubFiloModel getInterfaceSubFiloModel() {
		return new SubFiloModel();
	}

	public InterfaceClasseModel getInterfaceClasseModel() {
		return new ClasseModel();
	}

	public InterfaceSubClasseModel getInterfaceSubClasseModel() {
		return new SubClasseModel();
	}

	public InterfaceOrdemModel getInterfaceOrdemModel() {
		return new OrdemModel();
	}

	public InterfaceSubOrdemModel getInterfaceSubOrdemModel() {
		return new SubOrdemModel();
	}

	public InterfaceSuperFamiliaModel getInterfaceSuperFamiliaModel() {
		return new SuperFamiliaModel();
	}

	public InterfaceFamiliaModel getInterfaceFamiliaModel() {
		return new FamiliaModel();
	}

	public InterfaceSubFamiliaModel getInterfaceSubFamiliaModel() {
		return new SubFamiliaModel();
	}

	public InterfaceTriboModel getInterfaceTriboModel() {
		return new TriboModel();
	}

	public InterfaceGeneroModel getInterfaceGeneroModel() {
		return new GeneroModel();
	}

	public InterfaceSubGeneroModel getInterfaceSubGeneroModel() {
		return new SubGeneroModel();
	}

	public InterfaceEspecieModel getInterfaceEspecieModel() {
		return new EspecieModel();
	}

	public InterfaceSubEspecieModel getInterfaceSubEspecieModel() {
		return new SubEspecieModel();
	}

	public InterfaceVariedadeModel getInterfaceVariedadeModel() {
		return new VariedadeModel();
	}

	public InterfaceEspecimeModel getInterfaceEspecimeModel() {
		return new EspecimeModel();
	}

	public InterfaceInfraClasseModel getInterfaceInfraClasseModel() {
		return new InfraClasseModel();
	}

	public InterfaceLocalizacaoModel getInterfaceLocalizacaoModel() {
		return new LocalizacaoModel();
	}

}