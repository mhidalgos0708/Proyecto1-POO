package GUI;

import Modelo.TEstado;
import Modelo.TEstilo;
import Modelo.Vehiculo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
 

public class SeleccionadoVehículo extends JFrame implements ActionListener {
    String filename;
    String[] TiposLicencias = {"", "A1","A2","A3","A4","B1","B2","B3","B4","C1","C2","D1","D2","D3","E1","E2"};
    String[] TiposCarros = {"", "Compacto", "Pickup", "Intermedio", "SUV", "Mini-van", "Convertible", "Económico"};
    String[] VehículosCompacto={"", "Compacto1", "Compacto2"};
    String[] VehículosPickup={"", "Pickup1", "Pickup2"};
    String[] VehículosIntermedio={"", "Intermedio1", "Intermedio2"};
    String[] VehículosSUV={"", "SUV1", "SUV2"};
    String[] VehículosMinivan={"", "Mini-van1", "Mini-van2"};
    String[] VehículosConvertible={"", "Convertible1", "Convertible2"};
    String[] VehículosEconómico={"", "Económico1", "Económico2"};
    
    
    Container container = getContentPane();
    final JFileChooser explorer = new JFileChooser();
    
    JComboBox<String> ComboBoxTipoCarroSeleccionado = new JComboBox<>(TiposCarros);
    JComboBox<Vehiculo> ComboBoxVehículoSeleccionado = new JComboBox<>();
    DefaultComboBoxModel mod= new DefaultComboBoxModel(Inicio.adminApp.getListaVehiculos().toArray());
   
    
    JLabel TextoPlacaSeleccionado = new JLabel("No se ha seleccionado Vehículo");
    JLabel TextoAñoSeleccionado = new JLabel("No se ha seleccionado Vehículo");
    JLabel TextoColorSeleccionado = new JLabel("No se ha seleccionado Vehículo");
    JLabel TextoMarcaSeleccionado = new JLabel("No se ha seleccionado Vehículo");
    JLabel TextoKilometrajeSeleccionado = new JLabel("No se ha seleccionado Vehículo");
    JLabel TextoKCapacidadSeleccionado= new JLabel("No se ha seleccionado Vehículo");
    JLabel TextoPuertasSeleccionado= new JLabel("No se ha seleccionado Vehículo");
    JLabel TextoNombreCompleto = new JLabel("Tipo Vehículo");
    JLabel TextoCédula = new JLabel("Vehículo Seleccionado");
    JLabel TextoDirección = new JLabel("Placa");
    JLabel TextoCorreo = new JLabel("Año de Fabricación");
    JLabel TextoTeléfono = new JLabel("Color");
    JLabel TextoNumeroLicencia = new JLabel("Marca");
    JLabel TextoFechaEmisionLicencia = new JLabel("Capacidad Personas");
    JLabel TextoTipoLicencia = new JLabel("Kilometraje");
    JLabel TextoFechaExpiracionLicencia = new JLabel("Numero de Puertas");
    JLabel TextoImágen = new JLabel("Numero Vin");
    JLabel TextoURL =new JLabel("MPG");
    JLabel TextoSede =new JLabel("Sede");
    JLabel TextoCostoDiario =new JLabel("Costo Diario");
    JLabel TextoCapacidaddeMaletas =new JLabel("Capacidad de Maletas");
    JLabel TextoTipodeTransmisión =new JLabel("Tipo de Transmisión");
    JLabel TextoEstado =new JLabel("Estado");
    JLabel TextoListadeServicios =new JLabel("Lista de Servicios");
    JLabel TextoImagen =new JLabel("Imagen");
    JLabel TextoTL=new JLabel("");
    JLabel TextoTipoVehículoSeleccionado = new JLabel("");
    JLabel TextoVehiculoSeleccionado= new JLabel("");
    
    JLabel TextoMPGSeleccionado = new JLabel("No se ha seleccionado Vehículo");
    JLabel TextoSedeSeleccionado = new JLabel("No se ha seleccionado Vehículo");
    JLabel TextoCostoeleccionado = new JLabel("No se ha seleccionado Vehículo");
    JLabel TextoCapacidadSeleccionado = new JLabel("No se ha seleccionado Vehículo");
    JLabel TextoTipoTransimisionSeleccionado = new JLabel("No se ha seleccionado Vehículo");
    JLabel TextoEstadoSeleccionado = new JLabel("No se ha seleccionado Vehículo");
    JButton TextoListaServicioseleccionado = new JButton("Ver");
    JLabel TextoImagenSeleccionado = new JLabel("No se ha seleccionado Vehículo");
     
    JLabel TextoVinSeleccionado = new JLabel("No se ha seleccionado Vehículo");
    JButton botonAtras = new JButton("Atrás");
    JButton botonAgregarOperador = new JButton("Agregar");
 
 
 
    SeleccionadoVehículo() {
        
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
 
    }
 
    public void setLayoutManager() {
        container.setLayout(null);
    }
 
    public void setLocationAndSize() {
        TextoNombreCompleto.setBounds(40, 100, 150, 30);
        TextoCédula.setBounds(40, 140, 150, 30);
        TextoDirección.setBounds(40, 180, 150, 30);
        TextoCorreo.setBounds(40, 220, 150, 30);
        TextoTeléfono.setBounds(40, 260, 150, 30);
        TextoNumeroLicencia.setBounds(40, 300, 150, 30);
        TextoFechaEmisionLicencia.setBounds(40, 340, 150, 30);
        TextoTipoLicencia.setBounds(40, 380, 150, 30);
        TextoFechaExpiracionLicencia.setBounds(40, 420, 150, 30);
        TextoImágen.setBounds(40, 460, 150, 30);
        TextoURL.setBounds(40, 500, 300, 30);
        TextoTL.setBounds(120, 380, 150, 30);
        TextoVehiculoSeleccionado.setBounds(1,1,1,1);
        TextoTipoVehículoSeleccionado.setBounds(1,1,1,1);
        ComboBoxTipoCarroSeleccionado.setBounds(200, 100, 200, 30);
        ComboBoxVehículoSeleccionado.setBounds(200, 140, 200, 30);
        TextoPlacaSeleccionado.setBounds(200, 180, 200, 30); 
        TextoAñoSeleccionado.setBounds(200, 220, 200, 30); 
        TextoColorSeleccionado.setBounds(200, 260, 200, 30); 
        TextoMarcaSeleccionado.setBounds(200, 300, 200, 30); 
        TextoKCapacidadSeleccionado.setBounds(200, 340, 200, 30); 
        TextoKilometrajeSeleccionado.setBounds(200, 380, 200, 30); 
        TextoPuertasSeleccionado.setBounds(200, 420, 200, 30); 
        TextoVinSeleccionado.setBounds(200, 460, 200, 30);   
        botonAgregarOperador.setBounds(410, 140, 150, 30);
        TextoSede.setBounds(410, 180, 150, 30);
        TextoCostoDiario.setBounds(410, 220, 150, 30);
        TextoCapacidaddeMaletas.setBounds(410, 260, 150, 30);
        TextoTipodeTransmisión.setBounds(410, 300, 150, 30);
        TextoEstado.setBounds(410, 340, 150, 30);
        TextoListadeServicios.setBounds(410, 380, 150, 30);
        TextoImagen.setBounds(410, 420, 150, 30);       
        TextoMPGSeleccionado.setBounds(200, 500, 200, 30);
        TextoSedeSeleccionado.setBounds(570, 180, 200, 30);
        TextoCostoeleccionado.setBounds(570, 220, 200, 30);
        TextoCapacidadSeleccionado.setBounds(570, 260, 200, 30);
        TextoTipoTransimisionSeleccionado.setBounds(570, 300, 200, 30);
        TextoEstadoSeleccionado.setBounds(570, 340, 200, 30);
        TextoListaServicioseleccionado.setBounds(570, 380, 200, 30);
        TextoImagenSeleccionado.setBounds(530, 410, 250, 200);
        botonAgregarOperador.setBounds((200-150/2), 550, 150, 30);
        botonAtras.setBounds(200,30, 150, 30);

    }
 
    public void addComponentsToContainer() {
        
        container.add(TextoMPGSeleccionado);
        container.add(TextoSedeSeleccionado);
        container.add(TextoCostoeleccionado);
        container.add(TextoCapacidadSeleccionado);
        container.add(TextoTipoTransimisionSeleccionado);
        container.add(TextoEstadoSeleccionado);
        container.add(TextoListaServicioseleccionado);
        container.add(TextoImagenSeleccionado);
        container.add(botonAgregarOperador);
        container.add(TextoSede);
        container.add(TextoCostoDiario);
        container.add(TextoCapacidaddeMaletas);
        container.add(TextoTipodeTransmisión);
        container.add(TextoEstado);
        container.add(TextoListadeServicios);
        container.add(TextoImagen);
        container.add(TextoNombreCompleto);
        container.add(TextoCédula);
        container.add(TextoDirección);
        container.add(TextoCorreo);
        container.add(TextoTeléfono);
        container.add(TextoNumeroLicencia);
        container.add(TextoFechaEmisionLicencia);
        container.add(TextoTipoLicencia);
        container.add(TextoFechaExpiracionLicencia);
        container.add(TextoImágen);
        container.add(TextoTipoVehículoSeleccionado);
        container.add(ComboBoxTipoCarroSeleccionado);
        container.add(ComboBoxVehículoSeleccionado);
        container.add(TextoPlacaSeleccionado);
        container.add(TextoAñoSeleccionado);
        container.add(TextoColorSeleccionado);
        container.add(TextoMarcaSeleccionado);
        container.add(TextoKCapacidadSeleccionado);
        container.add(TextoKilometrajeSeleccionado);
        container.add(TextoPuertasSeleccionado);
        container.add(TextoVinSeleccionado);
        container.add(TextoURL);
        container.add(TextoTL);
        container.add(TextoVehiculoSeleccionado);
        container.add(botonAtras);
        ComboBoxVehículoSeleccionado.setEnabled(false);
    }
 
    public void addActionEvent() {

        botonAtras.addActionListener(this);
        botonAgregarOperador.addActionListener(this);
        ComboBoxTipoCarroSeleccionado.addActionListener( this);
        ComboBoxVehículoSeleccionado.addActionListener(this);
        TextoListaServicioseleccionado.addActionListener(this);
        
    }
 
 
    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if (e.getSource()==botonAtras){
            
            ComboBoxTipoCarroSeleccionado.setSelectedIndex(0);
            Inicio.frameRealizarReserva.setEnabled(true);
            Inicio.VentanaSeleccionadoVehículo(false);
          
        }
        if (e.getSource()==botonAgregarOperador){
            Vehiculo Auto = (Vehiculo) ComboBoxVehículoSeleccionado.getSelectedItem();
            
            if (ComboBoxTipoCarroSeleccionado.getSelectedItem().equals("")) {
                JOptionPane.showMessageDialog(this, "Por favor, seleccione un vehículo");
            
            } else if(Auto.getEstado().equals(TEstado.Inactivo)){
                JOptionPane.showMessageDialog(this, "Este vehículo se encuentra inactivo");
            }else {
                JOptionPane.showMessageDialog(this, "Se ha seleccionado un vehículo");
                RealizarReserva.AutoSeleccionado = (Vehiculo) ComboBoxVehículoSeleccionado.getSelectedItem();
                Inicio.frameRealizarReserva.TextoPlacaSeleccionada.setText(TextoPlacaSeleccionado.getText());
                ComboBoxTipoCarroSeleccionado.setSelectedIndex(0);
                Inicio.frameRealizarReserva.setEnabled(true);
                Inicio.VentanaSeleccionadoVehículo(false);   
                
            }

        }
        
        if(e.getSource()==TextoKilometrajeSeleccionado){
            JComboBox cb=(JComboBox)e.getSource();
            TextoTL.setText((String)cb.getSelectedItem());
        }
        if(e.getSource()==ComboBoxTipoCarroSeleccionado){
            Vehiculo Auto = (Vehiculo) ComboBoxVehículoSeleccionado.getSelectedItem();
            JComboBox cb=(JComboBox)e.getSource();
            TextoTipoVehículoSeleccionado.setText((String)cb.getSelectedItem());
            if("".equals((String)cb.getSelectedItem())){
                
                TextoPlacaSeleccionado.setText("No se ha seleccionado Vehículo");   
                TextoAñoSeleccionado.setText("No se ha seleccionado Vehículo");
                TextoColorSeleccionado.setText("No se ha seleccionado Vehículo");
                TextoMarcaSeleccionado.setText("No se ha seleccionado Vehículo");
                TextoKilometrajeSeleccionado.setText("No se ha seleccionado Vehículo");
                TextoKCapacidadSeleccionado.setText("No se ha seleccionado Vehículo");
                TextoPuertasSeleccionado.setText("No se ha seleccionado Vehículo");
                TextoMPGSeleccionado.setText("No se ha seleccionado Vehículo"); 
                TextoSedeSeleccionado.setText("No se ha seleccionado Vehículo");
                TextoCostoeleccionado.setText("No se ha seleccionado Vehículo");
                TextoCapacidadSeleccionado.setText("No se ha seleccionado Vehículo");
                TextoTipoTransimisionSeleccionado.setText("No se ha seleccionado Vehículo");
                TextoEstadoSeleccionado.setText("No se ha seleccionado Vehículo");
                TextoImagenSeleccionado.setText("No se ha seleccionado Vehículo");
                TextoVinSeleccionado.setText("No se ha seleccionado Vehículo");
                TablaServiciosAsociados.LimpiarTabla();
                TextoImagenSeleccionado.setIcon(null);
                ComboBoxVehículoSeleccionado.removeAllItems();
                ComboBoxVehículoSeleccionado.setEnabled(false);
                
            }
            
            if(!"".equals((String)cb.getSelectedItem())){
                
                ComboBoxVehículoSeleccionado.setEnabled(true);
                TextoTipoVehículoSeleccionado.setVisible(false);
                
                
            }
            if("Compacto".equals((String)cb.getSelectedItem())){
                
                ComboBoxVehículoSeleccionado.removeAllItems();
                DefaultComboBoxModel mod= new DefaultComboBoxModel(Inicio.adminApp.getVehiculosTipo(TEstilo.Compacto).toArray());
                ComboBoxVehículoSeleccionado.setModel(mod);
            }
            if("Pickup".equals((String)cb.getSelectedItem())){
                
                ComboBoxVehículoSeleccionado.removeAllItems();
                DefaultComboBoxModel mod= new DefaultComboBoxModel(Inicio.adminApp.getVehiculosTipo(TEstilo.PickUp).toArray());
                ComboBoxVehículoSeleccionado.setModel(mod);
            }
            if("Intermedio".equals((String)cb.getSelectedItem())){
                
                ComboBoxVehículoSeleccionado.removeAllItems();
                DefaultComboBoxModel mod= new DefaultComboBoxModel(Inicio.adminApp.getVehiculosTipo(TEstilo.Intermedio).toArray());
                ComboBoxVehículoSeleccionado.setModel(mod);
            }
            if("SUV".equals((String)cb.getSelectedItem())){
                
                ComboBoxVehículoSeleccionado.removeAllItems();
                DefaultComboBoxModel mod= new DefaultComboBoxModel(Inicio.adminApp.getVehiculosTipo(TEstilo.SUV).toArray());
                ComboBoxVehículoSeleccionado.setModel(mod);
            }
            if("Mini-van".equals((String)cb.getSelectedItem())){
                
                ComboBoxVehículoSeleccionado.removeAllItems();
                DefaultComboBoxModel mod= new DefaultComboBoxModel(Inicio.adminApp.getVehiculosTipo(TEstilo.MiniVan).toArray());
                ComboBoxVehículoSeleccionado.setModel(mod);
            }
            if("Convertible".equals((String)cb.getSelectedItem())){
                
                ComboBoxVehículoSeleccionado.removeAllItems();
                DefaultComboBoxModel mod= new DefaultComboBoxModel(Inicio.adminApp.getVehiculosTipo(TEstilo.Convertible).toArray());
                ComboBoxVehículoSeleccionado.setModel(mod);
            }
            if("Económico".equals((String)cb.getSelectedItem())){
                
                ComboBoxVehículoSeleccionado.removeAllItems();
                DefaultComboBoxModel mod= new DefaultComboBoxModel(Inicio.adminApp.getVehiculosTipo(TEstilo.Económico).toArray());
                ComboBoxVehículoSeleccionado.setModel(mod);
            }
            
        }
        if(e.getSource()==ComboBoxVehículoSeleccionado){
            JComboBox cb=(JComboBox)e.getSource();
            TextoVehiculoSeleccionado.setVisible(false);
            Vehiculo Auto = (Vehiculo) ComboBoxVehículoSeleccionado.getSelectedItem();
            if(cb.getSelectedItem() instanceof Vehiculo){
                
                TextoPlacaSeleccionado.setText(Auto.getPlaca());
                TextoAñoSeleccionado.setText(String.valueOf(Auto.getAñoFabricacion()));
                TextoColorSeleccionado.setText(Auto.getColor());
                TextoMarcaSeleccionado.setText(Auto.getMarca());
                TextoKilometrajeSeleccionado.setText(String.valueOf(Auto.getKilometraje()));
                TextoKCapacidadSeleccionado.setText(String.valueOf(Auto.getCapacidad()));
                TextoPuertasSeleccionado.setText(String.valueOf(Auto.getNumeroPuertas()));
                TextoMPGSeleccionado.setText(String.valueOf(Auto.getMpg())); 
                TextoSedeSeleccionado.setText(Auto.getSede());
                TextoCostoeleccionado.setText(String.valueOf(Auto.getCostoDiario())+"/d");
                TextoCapacidadSeleccionado.setText(String.valueOf(Auto.getCapacidad()));
                TextoTipoTransimisionSeleccionado.setText(Auto.getTipoTransmision().toString());
                TextoEstadoSeleccionado.setText(Auto.getEstado().toString());
                TextoVinSeleccionado.setText(Auto.getNumeroVin().toString());
                ImageIcon img= new ImageIcon(Auto.getImagen());
                TextoImagenSeleccionado.setIcon(img);
                TextoImagenSeleccionado.setText("Sin fotografía");
                Object[] filas= {};
                filas = Auto.getListaServiciosRelacionados().toArray();
                TablaServiciosAsociados.ModificarTablaServiciosAsociados(filas);
                
            }else{
                
                TextoPlacaSeleccionado.setText("No se ha seleccionado Vehículo");
                TextoAñoSeleccionado.setText("No se ha seleccionado Vehículo");
                TextoColorSeleccionado.setText("No se ha seleccionado Vehículo");
                TextoMarcaSeleccionado.setText("No se ha seleccionado Vehículo");
                TextoKilometrajeSeleccionado.setText("No se ha seleccionado Vehículo");
                TextoKCapacidadSeleccionado.setText("No se ha seleccionado Vehículo");
                TextoPuertasSeleccionado.setText("No se ha seleccionado Vehículo");
                TextoMPGSeleccionado.setText("No se ha seleccionado Vehículo"); 
                TextoSedeSeleccionado.setText("No se ha seleccionado Vehículo");
                TextoCostoeleccionado.setText("No se ha seleccionado Vehículo");
                TextoCapacidadSeleccionado.setText("No se ha seleccionado Vehículo");
                TextoTipoTransimisionSeleccionado.setText("No se ha seleccionado Vehículo");
                TextoEstadoSeleccionado.setText("No se ha seleccionado Vehículo");
                TextoImagenSeleccionado.setText("No se ha seleccionado Vehículo");
                TextoVinSeleccionado.setText("No se ha seleccionado Vehículo");
                TablaServiciosAsociados.LimpiarTabla();
                TextoImagenSeleccionado.setIcon(null);

            }
  
        }
        
        if(e.getSource()==TextoListaServicioseleccionado){
            
            Inicio.frameSeleccionadoVehículo.setEnabled(false);
            TablaServiciosAsociados.correrVentanilla();
        }

    }
 
}