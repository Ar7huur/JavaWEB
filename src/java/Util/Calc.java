package Util;

import java.text.DecimalFormat;
import sun.util.calendar.CalendarUtils;

public class Calc {

    private int qtd_parc;
    private double montante, juros, saldoDev, auxJuros;

    public Calc(double montante, double juros, int qtd_parc) {
        this.montante = montante;
        this.juros = juros;
        this.qtd_parc = qtd_parc;
        saldoDev = montante;
    }

    public int getQtd_parc() {
        return qtd_parc;
    }


    public double get_ValorParcela() {
        double parcelas = (Math.pow(1 + juros / 100, qtd_parc) * (juros / 100)) / (Math.pow(1 + juros / 100, qtd_parc) - 1);
        return montante * parcelas;
//        return Math.round(parcelas*100.00)/100.00 ;
    }

    public double get_CalcJuros() {
        auxJuros = saldoDev * (juros / 100);
        return auxJuros;
    }

    //ARRUMAR O TOTAL DE JUROS PAGO - FAIL
    
    public double getTotalPago() {
        double x, y;
        x = get_ValorParcela() * qtd_parc;
        y = x - montante;
        return y;
    }
    

    public double get_SaldoDevedor() {
        return saldoDev = saldoDev - get_CalcAmortizacao();
    }

    public double get_CalcAmortizacao() {
        double amortizacao = get_ValorParcela() - get_CalcJuros();
        return amortizacao;
    }

}
