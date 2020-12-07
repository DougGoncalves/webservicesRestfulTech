import React, {useContext} from 'react'
import {DoadorContext} from '../store/store'
import {Col, Table, Alert} from 'reactstrap'

export default()=>{
    const [state] = useContext(DoadorContext);
    const rows = state.doadores.map((doador, index) => 
        <tr key={index}>
            <td>{doador.name}</td>
            <td>{doador.age}</td>
            <td>{doador.bloodtype}</td>
            <td>{doador.rg}</td>
        </tr>
    )
    if (state.doadores.length > 0) {
        return (
            <Col md="8">
                <h3>Doadores cadastrados</h3>
                    <Table striped>
                        <thead>
                            <tr>
                                <td>Nome</td>
                                <td>Idade</td>
                                <td>Tipo Sanguineo</td>
                                <td>RG</td>
                            </tr>
                        </thead>
                        <tbody>
                            {rows}
                        </tbody>
                    </Table>
    
            </Col>
        )
    } else {
        return (
            <Col md="8">
                <h3>Doadores cadastrados</h3>
                <Alert color="info">Nenhum doador cadastrado no momento.</Alert>
            </Col>
        )
    }
}