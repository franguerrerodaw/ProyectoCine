package personal;

import java.io.Serializable;
import java.util.ArrayList;

import utiles.Gestion;

/**
 * 
 * @author Francisco Javier Guerrero Molina
 * @version 1.0
 *
 */
public class ListaPersonas implements Serializable {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Colección de personas.
	 */
	private ArrayList<Persona> listaPersonas = new ArrayList<Persona>();

	
	/**
	 * Agrega una persona al ArrayList. agrega persona al ArrayList y modifica el valor del campo
	 *         modificado
	 * 
	 * @param persona
	 * @param dni
	 * @return true si la persona ha sido añadida correctamente.
	 * @throws EmpleadoYaExisteException
	 * @throws DniInvalidoException
	 */
	public boolean agregarPersona(Persona persona, String dni)
			throws EmpleadoYaExisteException, DniInvalidoException {
		if (get(dni))
			throw new EmpleadoYaExisteException("El empleado ya existe");
		return listaPersonas.add(persona) && Gestion.setModificado(true);
	}

	public boolean agregarPuesto(Persona persona) {
		return listaPersonas.add(persona);
	}

	/**
	 * Elimina a la persona elegida a través del DNI
	 * 
	 * @param id
	 * @return persona que se va a eliminar
	 * @throws PersonaNoExisteException
	 * @throws DniInvalidoException
	 */
	public boolean eliminar(Persona persona) throws PersonaNoExisteException,
			DniInvalidoException {
		return listaPersonas.remove(persona) && Gestion.setModificado(true);
	}

	/**
	 * Busca el empleado en el ArrayList a través del DNI, se utiliza para
	 * mostrar un empleado antes de eliminarlo y buscarlo por DNI.
	 * 
	 * @param dni
	 * @return empleado almacenado en el ArrayList
	 * @throws EmpleadoNoExisteException
	 * @throws DniInvalidoException
	 * @throws PersonaNoExisteException
	 */
	public Persona getP(String dni) throws DniInvalidoException,
			PersonaNoExisteException {
		Persona persona = null;
		for (Persona empleado : listaPersonas) {
			if (empleado.getDni().equals(dni)) {
				persona = empleado;
			}
		}
		if (!listaPersonas.contains(persona)) {
			throw new PersonaNoExisteException("El empleado no existe.");
		}
		return persona;
	}

	/**
	 * Busca un empleado a través del DNI. Se utiliza para no añadir un empleado
	 * con el mismo DNI.
	 * 
	 * @param dni
	 * @return
	 * @throws DniInvalidoException
	 */
	private boolean get(String dni) throws DniInvalidoException {
		Persona persona = new Persona(dni);
		for (Persona empleado : listaPersonas) {
			if (empleado.getDni().equals(dni)) {
				persona = empleado;
			}
		}
		if (listaPersonas.contains(persona))
			return true;
		return false;
	}

	/**
	 * Comprueba si hay más elementos antes o después del ArrayList, se utiliza
	 * para mostrar empleados.
	 * 
	 * @param index
	 * @return empleado almacenado en el ArrayList
	 */
	public Persona getIndex(int index) {
		if (listaPersonas.isEmpty())
			return null;
		if (index < 0 || index > listaPersonas.size() - 1)
			return null;
		return listaPersonas.get(index);
	}

	/**
	 * Elementos del ArrayList
	 * 
	 * @return elementos del ArrayList
	 */
	public int size() {
		return listaPersonas.size();
	}
	
	
	public void set(int index, Persona persona) {
		listaPersonas.set(index, persona);
	}
	

	public ArrayList<Persona> getPuesto(Puesto puesto) {
		ArrayList<Persona> arrPersona = new ArrayList<Persona>();
		switch (puesto) {
		case DIRECTOR:
			for (Persona empleado : listaPersonas) {
				if (empleado instanceof Director)
					arrPersona.add(empleado);
			}
			return arrPersona;
		case EMPLEADO_SALA:
			for (Persona empleado : listaPersonas) {
				if (empleado instanceof EmpleadoSala)
					arrPersona.add(empleado);
			}
			return arrPersona;
		default:// case LIMPIEZA:
			for (Persona empleado : listaPersonas) {
				if (empleado instanceof Limpiador)
					arrPersona.add(empleado);
			}
			return arrPersona;
			// default:
			// break;
		}
		// return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ListaPersonas [listaPersonas=" + listaPersonas + "]";
	}

}
