/// <reference types="cypress" />

context('Index page', () => {
  beforeEach(() => {
    cy.visit('http://localhost:8081/');
  })

  it('User can get to the login page from the index page', () => {
  	cy.title().should('include', 'Sticks');
  	cy.contains('Login');
  	cy.contains('Register').click();
  	cy.contains("register");
  })
})