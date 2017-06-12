package util;

import org.apache.commons.lang3.builder.EqualsBuilder;

public class ValidaApi {

public static void validar(Object objeto, Object objeto2){
		
		if(!EqualsBuilder.reflectionEquals(objeto, objeto2, false)){
			throw new AssertionError("O resultado Retornado é diferente do Resultado Esperado");
		}
}

}
