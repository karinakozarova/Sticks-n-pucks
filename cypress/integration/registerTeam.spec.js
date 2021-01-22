/// <reference types="cypress" />

context('Teams listing', () => {
  beforeEach(() => {
    cy.visit('http://localhost:8081/teams/register');
  })

  it('Teams lisitng page has cards', () => {
  	cy.title().should('include', 'Register');
  	cy.contains('Create your team');
  	cy.contains('Name');
    cy.contains('Location');
  })

  it('Navbar is available', () => {
  	cy.contains('Home');
  	cy.contains('Roster');
  	cy.contains('Analytics');
  })
})
