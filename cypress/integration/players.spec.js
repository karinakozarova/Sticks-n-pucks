/// <reference types="cypress" />

context('Players', () => {
  beforeEach(() => {
    cy.visit('http://localhost:8081/players/all');
  })

  it('Players lisitng page has cards', () => {
  	cy.title().should('include', 'View players');
  	cy.contains('Patrick Kane');
  	cy.contains('Height');
    cy.contains('Weight');
    cy.contains('Position');
    cy.contains('Shoots');

  })

  it('Navbar is available', () => {
  	cy.contains('Home');
  	cy.contains('Roster');
  	cy.contains('Analytics');
  })
})
