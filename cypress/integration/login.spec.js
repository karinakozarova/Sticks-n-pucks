/// <reference types="cypress" />

context('Index page', () => {
  beforeEach(() => {
    cy.visit('http://localhost:8081/');
  })

  it('User can get to the login page from the index page', () => {
    // https://on.cypress.io/get
	cy.title().should('include', 'Sticks');
	cy.contains('Subscribe');
	cy.contains('Subscribe').click();
	cy.contains("Login");
  })




})
