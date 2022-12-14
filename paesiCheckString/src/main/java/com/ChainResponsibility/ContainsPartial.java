package com.ChainResponsibility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.strategy.Strategy;

public class ContainsPartial extends CheckChain {
	@Override
	public String checkInternal(String input) {
        String result=null;
        //L'IDEA E' QUELLA DI SEPARARE LE STRINGHE E CONTROLLARE I SINGOLI ELEMENTI. 
        //SE HO KOREA SUD DEVE ESSERE UGUALE A SUD KOREA
        List<String> stringaDaRicondurre=Arrays.asList(input.split(" "));
        List<String> copyStringaDaRicondurre=new ArrayList(stringaDaRicondurre);
        for (String key : super.getStrategy().getStandards()) {
            List<String> paeseDaRicondurre=Arrays.asList(key.split(" "));
            List<String> copyPaeseDaRicondurre=new ArrayList(paeseDaRicondurre);
            copyStringaDaRicondurre.retainAll( paeseDaRicondurre);
            copyPaeseDaRicondurre.retainAll( stringaDaRicondurre);
            if(copyStringaDaRicondurre.size()>2*stringaDaRicondurre.size()/3||
                    copyPaeseDaRicondurre.size()>2*paeseDaRicondurre.size()/3) 
                return key;
        }

        return null;

	}
}
