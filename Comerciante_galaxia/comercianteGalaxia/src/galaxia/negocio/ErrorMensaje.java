/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package galaxia.negocio;

/**
 *
 * @author Keren
 */
public class ErrorMensaje {
    
        public ErrorMensaje(){
		
	}
	
	/**
	 * This method prints the message for the particular error code
	 */
	public void printMessage(ErrorCodigo error)
	{
		String message= getMessage(error);
		
		if(message !=null)
                System.out.println(message);
		
	}
	
	public String getMessage(ErrorCodigo error)
	{
		String message= null;
		
		switch(error)
		{
			case NO_INPUT : message = "¡No se especificó ninguna entrada! Programa salido";
							break;
			case INVALID : message = "¡El formato de entrada es incorrecto! entrada descartada";break;
			
			case INVALID_ROMAN_CHARACTER : message = "¡Carácter ilegal especificado en número romano! entrada descartada";break;
			
			case INVALID_ROMAN_STRING : message =  "número romano incorrecto, formato de número romano volado";break;
			
			case INCORRECT_LINE_TYPE : message =  "Excepción causada durante el procesamiento debido a un tipo de línea incorrecto proporcionado";break;
			
			case NO_IDEA : message = "No tengo ni idea de lo que estás hablando";break;
			
			default : break;
		}
		return message;
	}
    
}
