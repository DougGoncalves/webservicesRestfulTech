import React, {useContext} from 'react'
import {DoadorContext} from '../store/store'
import {Col, Table, Alert} from 'reactstrap'

export default()=>{
    var style1 = {
        backgroundColor: '#efefef'
    }

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
                <Table striped style={style1}>
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
                <Alert color="danger">Nenhum doador cadastrado no momento.</Alert>
            </Col>
        )
    }
}