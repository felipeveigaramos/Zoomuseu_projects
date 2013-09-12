package br.edu.utfpr.cm.zoomuseu_data.controller;

public class ControllerFactory {

	private static ControllerFactory instance = null;

	private ControllerFactory() {

	}

	public static ControllerFactory getInstance() {
		if (ControllerFactory.instance == null) {
			ControllerFactory.instance = new ControllerFactory();
		}
		return ControllerFactory.instance;
	}

	public InterfaceFiloController getInterfaceFiloController() {
		return new FiloController();
	}

	public InterfaceSubFiloController getInterfaceSubFiloController() {
		return new SubFiloController();
	}

	public InterfaceClasseController getInterfaceClasseController() {
		return new ClasseController();
	}

	public InterfaceSubClasseController getInterfaceSubClasseController() {
		return new SubClasseController();
	}

	public InterfaceOrdemController getInterfaceOrdemController() {
		return new OrdemController();
	}

	public InterfaceSubOrdemController getInterfaceSubOrdemController() {
		return new SubOrdemController();
	}

	public InterfaceSuperFamiliaController getInterfaceSuperFamiliaController() {
		return new SuperFamiliaController();
	}

	public InterfaceFamiliaController getInterfaceFamiliaController() {
		return new FamiliaController();
	}

	public InterfaceSubFamiliaController getInterfaceSubFamiliaController() {
		return new SubFamiliaController();
	}

	public InterfaceTriboController getInterfaceTriboController() {
		return new TriboController();
	}

	public InterfaceGeneroController getInterfaceGeneroController() {
		return new GeneroController();
	}

	public InterfaceSubGeneroController getInterfaceSubGeneroController() {
		return new SubGeneroController();
	}

	public InterfaceEspecieController getInterfaceEspecieController() {
		return new EspecieController();
	}

	public InterfaceSubEspecieController getInterfaceSubEspecieController() {
		return new SubEspecieController();
	}

	public InterfaceVariedadeController getInterfaceVariedadeController() {
		return new VariedadeController();
	}

	public InterfaceEspecimeController getInterfaceEspecimeController() {
		return new EspecimeController();
	}

	public InterfaceInfraClasseController getInterfaceInfraClasseController() {
		return new InfraClasseController();
	}

	public InterfaceLocalizacaoController getInterfaceLocalizacaoController() {
		return new LocalizacaoController();
	}

}