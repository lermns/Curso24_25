package orm;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity
@Table(name="empleado_datos_prof"
    ,catalog="ut3demo2"
)
public class EmpleadoDatosProf  implements java.io.Serializable {


     private String dni;
     private Empleado empleado;
     private String categoria;
     private BigDecimal sueldoBrutoAnual;

    public EmpleadoDatosProf() {
    }

	
    public EmpleadoDatosProf(Empleado empleado, String categoria) {
        this.empleado = empleado;
        this.categoria = categoria;
    }
    public EmpleadoDatosProf(Empleado empleado, String categoria, BigDecimal sueldoBrutoAnual) {
       this.empleado = empleado;
       this.categoria = categoria;
       this.sueldoBrutoAnual = sueldoBrutoAnual;
    }
   
     @GenericGenerator(name="generator", strategy="foreign", parameters=@Parameter(name="property", value="empleado"))@Id @GeneratedValue(generator="generator")

    
    @Column(name="dni", unique=true, nullable=false, length=9)
    public String getDni() {
        return this.dni;
    }
    
    public void setDni(String dni) {
        this.dni = dni;
    }

@OneToOne(fetch=FetchType.LAZY)@PrimaryKeyJoinColumn
    public Empleado getEmpleado() {
        return this.empleado;
    }
    
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    
    @Column(name="categoria", nullable=false, length=2)
    public String getCategoria() {
        return this.categoria;
    }
    
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    
    @Column(name="sueldo_bruto_anual", precision=8)
    public BigDecimal getSueldoBrutoAnual() {
        return this.sueldoBrutoAnual;
    }
    
    public void setSueldoBrutoAnual(BigDecimal sueldoBrutoAnual) {
        this.sueldoBrutoAnual = sueldoBrutoAnual;
    }




}


