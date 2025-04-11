package modelo;

public class CuentaDeAhorro extends CuentaBancaria {
    private final double tasaInteresAnual;

    public CuentaDeAhorro(String titular, String tipoCuenta, double saldo, double tasaInteresAnual) {
        super(titular, tipoCuenta, saldo);
        this.tasaInteresAnual = tasaInteresAnual;
    }

    public void aplicarInteresMensual() {
        double interesMensual = (saldo * (tasaInteresAnual / 12));
        saldo += interesMensual;
    }

    public double getTasaInteresAnual() {
        return tasaInteresAnual;
    }
}
