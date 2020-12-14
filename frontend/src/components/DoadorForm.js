import React, { useContext, useState } from 'react'
import { DoadorContext } from '../store/store'
import { Col, Form, FormGroup, Label, Input, Button } from 'reactstrap'

export default () => {
    const name = useFormInput("")
    const age = useFormInput("")
    const bloodtype = useFormInput("")
    const rg = useFormInput("")
    // eslint-disable-next-line no-unused-vars
    const [state, dispatch] = useContext(DoadorContext)

    const request = (data) => {
        fetch('http://localhost:8081/v1/donors', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(data)
        })
            .then(response => {
                console.log("Data Saved");
            });
    }

    const onSubmit = event => {

        const data = {
            name: name.value, age: age.value, bloodtype: bloodtype.value,
            rg: rg.value
        }

        event.preventDefault()
        dispatch({
            type: "ADD_DOADOR",
            payload: data
        })

        request(data);
    };



    return (
        <Col className="form" md="4">
            <Form onSubmit={onSubmit}>
                <FormGroup>
                    <Label>Nome:</Label>
                    <Input {...name} type="text" name="name" required autoFocus />
                </FormGroup>
                <FormGroup>
                    <Label>Idade:</Label>
                    <Input {...age} type="text" name="age" required />
                </FormGroup>
                <FormGroup>
                    <Label>Tipo Sanguineo:</Label>
                    <Input {...bloodtype} type="text" name="bloodtype" required />
                </FormGroup>
                <FormGroup>
                    <Label>RG:</Label>
                    <Input {...rg} type="text" name="rg" required />
                </FormGroup>
                <Button color="primary" size="lg" block>Adicionar</Button>
            </Form>
        </Col>
    )
}

function useFormInput(initialValue) {
    const [value, setValue] = useState(initialValue)
    const handleChange = e => {
        setValue(e.target.value)
    }
    return {
        value,
        onChange: handleChange
    }
}