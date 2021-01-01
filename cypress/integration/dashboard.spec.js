/// <reference types="cypress" />

context('Teams', () => {
  beforeEach(() => {
    cy.visit('http://localhost:8081/dashboard', {failOnStatusCode: false});
  })

  it('Navbar is available', () => {
  	cy.contains('Home');
  	cy.contains('Roster');
  	cy.contains('Analytics');
  })
})
