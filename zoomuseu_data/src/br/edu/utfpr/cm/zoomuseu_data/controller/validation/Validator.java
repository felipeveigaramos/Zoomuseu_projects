package br.edu.utfpr.cm.zoomuseu_data.controller.validation;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.resource.spi.SecurityException;



public class Validator {
	public static boolean validar(Object o, boolean verificar)
			throws ValidationException, IllegalArgumentException,
			IllegalAccessException, SecurityException {

		if (o == null) {
			return false;
		}
		Class<?> classe = o.getClass();

		List<Report> erros = Validator.validarCampos(
				classe.getDeclaredFields(), o, verificar);

		boolean eValido = false;

		if (erros != null && erros.size() > 0) {
			throw new ValidationException("Entidade inv�lida.", erros);
		} else {
			eValido = true;
		}

		return eValido;
	}

	@SuppressWarnings("deprecation")
	private static List<Report> validarCampos(Field[] fields, Object o,
			boolean verificar) throws IllegalArgumentException,
			IllegalAccessException {
		List<Report> erros = new ArrayList<Report>();

		for (Field f : fields) {
			String campo;
			String erro = "";
			f.setAccessible(true);
			campo = f.getName();
			if (verificar && campo.equals("nome") && f.get(o) != null
					&& f.get(o).toString().equalsIgnoreCase("n�o consta")) {
				erros.add(new Report(campo,
						"N�o � poss�vel criar ou editar \"N�o Consta\""));
			} else {
				if (f.isAnnotationPresent(Column.class)) {
					Column annotation = f.getAnnotation(Column.class);
					if (annotation.nullable() == false
							&& (f.get(o) == null || f.get(o).toString()
									.equals(""))
							&& !f.isAnnotationPresent(Id.class)) {
						erro += erro.length() > 0 ? ", " : "";
						erro += "n�o pode ser nulo";
					}
					if (f.get(o) != null
							&& annotation.length() < f.get(o).toString()
									.length()) {
						erro += erro.length() > 0 ? ", " : "";
						erro += "n�o pode ter mais de " + annotation.length()
								+ " caracteres";
					}

					if (f.getType() == Date.class) {
						Date data = new Date();
						Date dataCadastrada = (Date) f.get(o);

						if (dataCadastrada.before(data)
								&& (data.getYear() - dataCadastrada.getYear()) > 20) {
							erro += erro.length() > 0 ? ", " : "";
							erro += "� muito antiga";
						}
						if (dataCadastrada.after(data)) {
							erro += erro.length() > 0 ? ", " : "";
							erro += "n�o pode ser futura";
						}
					}
				}
				if (campo != null && campo.length() > 0 && erro != null
						&& erro.length() > 0) {
					erros.add(new Report(campo, erro));
				}

			}
		}
		return erros;
	}
}
