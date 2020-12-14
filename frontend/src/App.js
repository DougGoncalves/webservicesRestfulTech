import React from 'react';
import './styles/App.css';
import { Container, Row, Col } from 'reactstrap'
import DoadorForm from './components/DoadorForm'
import DoadorList from './components/DoadorList'
import { DoadorContextProvider } from './store/store'


export default () => {
  return (
    <DoadorContextProvider>
      <h1 className="title">API - Banco de Sangue 💉</h1>
      <Container>
        <Row className="justify-content-center">
          <Col md="12">
            <h1><strong>Cadastramento de Doador</strong></h1>
            <hr className="hr" />
          </Col>
          <DoadorForm />
          <DoadorList />
        </Row>
      </Container>
    </DoadorContextProvider> 
  )
}